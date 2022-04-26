package com.wyhw.pmp;

import com.wyhw.pmp.generator.AbstractMainGenerator;
import com.wyhw.pmp.generator.executor.GeneratorExecutorOriginal;
import org.junit.Test;

/**
 * @author wanyanhw
 * @date 2022/4/26 14:33
 */
public class CodeGeneratorTest {
    @Test
    public void generate() {
        AbstractMainGenerator generator = new GeneratorExecutorOriginal();
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/pmp?serverTimezone=Asia/Shanghai&useSSL=false&useUnicode=true&characterEncoding=UTF-8&rewriteBatchedStatements=true&allowMultiQueries=true";
        String username = "root";
        String password = "Zkong_1234";
        String[] tableNames = {
                "base_relationship",
                "person",
                "person_archive",
                "person_relationship"
        };
        generator.author("wanyanhw")
                .dataSource(driver, url, username, password)
                .includeTable(tableNames)
                .openDir(false)
                .disableController()
                .basePath("E:\\space\\idea\\pmp-server\\src\\main\\java")
                .parentPackagePath("com.wyhw.pmp")
                .mapperXmlPath("E:\\space\\idea\\pmp-server\\src\\main\\resources\\mapping")
                .execute();
    }
}
