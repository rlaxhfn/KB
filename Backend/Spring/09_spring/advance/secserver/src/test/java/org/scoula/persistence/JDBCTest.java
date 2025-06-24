package org.scoula.persistence;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.fail;

@Log4j2
public class JDBCTest {
    @BeforeAll
    public static void setup(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("JDBC connect")
    public void testConnection(){
        String url = "jdbc:mysql://localhost:3306/scoula_db";
        try(Connection connection = DriverManager.getConnection(url, "scoula", "1234");) {
            log.info(connection);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
