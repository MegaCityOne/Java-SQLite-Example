package com.naglfar_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static String URL = "jdbc:sqlite:Bodies.db";
    static Connection conn = null;
    static void connect() {
        try {
            conn = DriverManager.getConnection(URL);
            conn.setAutoCommit(false);
            System.out.println("Connection to SQLite has been established.");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}