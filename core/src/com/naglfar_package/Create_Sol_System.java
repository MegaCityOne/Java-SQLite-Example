package com.naglfar_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Sol_System {
    static String delete_sol_bodies_table_if_exists_query = "DROP TABLE IF EXISTS bodies";
    static String create_new_sol_bodies_table_query = "CREATE TABLE bodies (parent_system TEXT NOT NULL,parent_body TEXT NOT NULL,body_name TEXT NOT NULL PRIMARY KEY,orbit_distance REAL NOT NULL,current_orbit_angle REAL NOT NULL,orbit_angle_change_per_second REAL NOT NULL,x_position REAL NOT NULL,y_position REAL NOT NULL)";
    static String insert_sol_query = "INSERT INTO bodies VALUES ('Sol','None','Sol','0','0','0','400','300')";
    static String insert_earth_query = "INSERT INTO bodies VALUES ('Sol','Sol','Earth','200','0','0.002','0','0')";
    static String insert_moon_query = "INSERT INTO bodies VALUES ('Sol','Earth','Moon','50','0','0.005','0','0')";
    static void create_sol_bodies_table() {
        try {
            System.out.println(Connect.conn);
            Statement stmt = Connect.conn.createStatement();

            stmt.execute(delete_sol_bodies_table_if_exists_query);
            System.out.println(stmt);
            stmt.execute(create_new_sol_bodies_table_query);
            System.out.println(stmt);
            stmt.execute(insert_sol_query);
            System.out.println(stmt);
            stmt.execute(insert_earth_query);
            System.out.println(stmt);
            stmt.execute(insert_moon_query);
            System.out.println(stmt);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}