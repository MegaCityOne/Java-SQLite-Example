package com.naglfar_package;

import java.sql.SQLException;
import java.sql.Connection;

public class Disconnect {
    static void disconnect() {
        try {
            Connect.conn.commit();
            Connect.conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
