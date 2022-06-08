package com.wyhw.pmp.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanyanhw
 * @date 2022/6/7 20:30
 */
@Slf4j
public class SqlFileReader {

    // 数据控制语言(Database Control Language)（自动提交，不支持回滚）
    private final static String[] DCL = {"GRANT", "REVOKE"};

    // 执行数据定义语言(Database Definition Language)（自动提交，不支持回滚）
    private final static String[] DDL = {"CREATE", "ALTER", "DROP", "TRUNCATE"};

    // 执行数据定义语言(Database Manipulation Language)（支持回滚）
    private final static String[] DML = {"INSERT", "UPDATE", "DELETE"};

    private static Connection connection = null;

    @Test
    public void executeSql() {
        List<StringBuilder> sqlList = read("C:\\Users\\wanyanhw\\Desktop\\lcd_1.2.9.sql");
        try {
            createConnection();
            // DCL 和 DDL 语句不支持回滚，语句执行前后会自动 commit
            executeSql(connection, sqlList, DCL);
            executeSql(connection, sqlList, DDL);
            // 支持回滚的操作
            executeSql(connection, sqlList, DML);
            connection.commit();
            log.info("SQL执行完成");
        } catch (Exception e) {
            log.error("SQL 执行异常", e);
            rollback();
        } finally {
            closeConnection();
        }
    }

    /**
     * 读取 sql 文件中的 SQL 语句
     * @param path 文件路径
     * @return sql 语句集合
     */
    private List<StringBuilder> read(String path) {
        File file = new File(path);
        List<StringBuilder> sqlList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String lineS;
            do {
                lineS = bufferedReader.readLine();
                if (lineS == null) {
                    break;
                }
                if (lineS.isEmpty() || lineS.startsWith("#") || lineS.startsWith("-") || lineS.startsWith("/*")) {
                    continue;
                }
                int size = sqlList.size();
                if (size == 0) {
                    sqlList.add(new StringBuilder());
                }
                size = sqlList.size();
                sqlList.get(size - 1).append("\n").append(lineS);
                if (lineS.endsWith(";")) {
                    sqlList.add(new StringBuilder());
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlList;
    }

    /**
     * 创建数据库连接
     * @throws Exception 异常
     */
    private void createConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/lcd?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "Zkong_1234";
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
    }

    /**
     * 执行 sql 语句
     * @param connection 数据库连接
     * @param sqlList 待执行 SQL 语句列表
     * @param sqlType SQL 语句类型
     * @throws SQLException 异常
     */
    private void executeSql(Connection connection, List<StringBuilder> sqlList, String[] sqlType) throws SQLException {
        List<StringBuilder> collect = sqlList.stream().filter(sql -> matchSQLType(sql, sqlType)).collect(Collectors.toList());
        for (StringBuilder sql : collect) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            try {
                preparedStatement.execute(sql.toString());
            } catch (SQLException e) {
                throw new SQLException(sql.toString(), e);
            }
        }
    }

    private boolean matchSQLType(StringBuilder sql, String[] sqlType) {
        String upperSql = sql.toString().toUpperCase().trim();
        for (String dcl : sqlType) {
            boolean match = upperSql.startsWith(dcl);
            if (match) {
                return true;
            }
        }
        return false;
    }

    private void rollback() {
        if (connection != null) {
            try {
                System.out.println("异常回滚");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
