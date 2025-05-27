package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    @DisplayName("DB 연결")
    // 문제 5
    public void testConnection() throws SQLException, ClassNotFoundException {
        Connection con = null;
        // 1. 드라이브 설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("드라이브 설정 성공");
        // 2. db 연결
        String url = "jdbc:mysql://localhost:3306/jdbc_ex";
        String user = "scoula";
        String password = "1234";
        con = DriverManager.getConnection(url, user, password);
        System.out.println("db 연결 성공");
        // 3. db 연결 해제
        con.close();
        System.out.println("db 연결 해제");
    }
    // 문제 8
    @Test
    @DisplayName("DB 연결2")
    public void testConnection2() throws SQLException {
        try(Connection con = JDBCUtil.getConnection()) {
            System.out.println("db 연결 성공");
        }
    }
}
