package com.wyhw.pmp;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author wanyanhw
 * @date 2022/6/22 10:29
 */
public class JDBCTest {
    String url = "jdbc:mysql://127.0.0.1:3306/pmp?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
    String username = "root";
    String password = "Zkong_1234";
    @Test
    public void connect() throws Exception {
        Connection connection = null;
        try {
            String sql = "select * from person;";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            connection.commit();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
