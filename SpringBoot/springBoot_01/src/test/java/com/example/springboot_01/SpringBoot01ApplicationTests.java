package com.example.springboot_01;

import com.example.springboot_01.domain.dbconnection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
class SpringBoot01ApplicationTests {
    @Autowired
    private Environment environment;
    @Autowired
    private dbconnection dbconnection;

    @Test
    void contextLoads() {
    }

    @Test
    public void testConnectDB() throws ClassNotFoundException, SQLException {
        /*System.out.println(this.environment.getProperty(dbconnection.getDriver()));
        System.out.println(dbconnection.getDriver());*/
        Class.forName(this.environment.getProperty(dbconnection.getDriver()));
        Connection connection = DriverManager.getConnection(dbconnection.getUrl(),dbconnection.getUsername(),dbconnection.getPassword());
    }


}
