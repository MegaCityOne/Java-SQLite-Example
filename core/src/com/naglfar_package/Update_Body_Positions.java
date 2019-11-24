package com.naglfar_package;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_Body_Positions {
    static void update_body_positions(){
        try {

            int update_bodies_current_row = 1;

            Statement stmt = Connect.conn.createStatement();

            String number_of_bodies_query = "SELECT COUNT(*) FROM bodies";
            ResultSet rs = stmt.executeQuery(number_of_bodies_query);
            int number_of_bodies_to_update = rs.getInt(1);

            String update_all_body_orbit_angles_query = "UPDATE bodies SET current_orbit_angle = current_orbit_angle + orbit_angle_change_per_second";
            stmt.executeUpdate(update_all_body_orbit_angles_query);          //Add orbit_angle_change_per_second to current_orbit_angle

            while(update_bodies_current_row <= number_of_bodies_to_update) {
                String get_body_current_orbit_angle_query = "SELECT current_orbit_angle FROM bodies WHERE rowid = " + String.valueOf(update_bodies_current_row) + "";
                rs = stmt.executeQuery(get_body_current_orbit_angle_query);
                double body_current_orbit_angle = rs.getDouble(1);

                if (body_current_orbit_angle > (2*Math.PI)) {
                    body_current_orbit_angle = body_current_orbit_angle - (2 * Math.PI);
                }

                String get_body_orbit_distance_query = "SELECT orbit_distance FROM bodies WHERE rowid = " + String.valueOf(update_bodies_current_row) + "";
                rs = stmt.executeQuery(get_body_orbit_distance_query);
                float body_orbit_distance = rs.getFloat(1);

                String get_parent_body_query = "SELECT parent_body FROM bodies WHERE rowid = " +String.valueOf(update_bodies_current_row)+ "";
                rs = stmt.executeQuery(get_parent_body_query);
                String parent_body_name = rs.getString(1);

                if (!parent_body_name.equals("None")){

                    String get_parent_body_x_position_query = "SELECT x_position FROM bodies WHERE body_name = '" + parent_body_name + "'";
                    rs = stmt.executeQuery(get_parent_body_x_position_query);
                    double parent_body_x_position = rs.getDouble(1);

                    String get_parent_body_y_position_query = "SELECT y_position FROM bodies WHERE body_name = '" + parent_body_name + "'";
                    rs = stmt.executeQuery(get_parent_body_y_position_query);
                    double parent_body_y_position = rs.getDouble(1);

                    double new_body_x_position = parent_body_x_position + body_orbit_distance * (Math.cos(body_current_orbit_angle));
                    double new_body_y_position = parent_body_y_position + body_orbit_distance * (Math.sin(body_current_orbit_angle));

                    String update_body_x_position_query = "UPDATE bodies SET x_position = " + String.valueOf(new_body_x_position) + " WHERE rowid = " + String.valueOf(update_bodies_current_row) + "";
                    stmt.executeUpdate(update_body_x_position_query);

                    String update_body_y_position_query = "UPDATE bodies SET y_position = " + String.valueOf(new_body_y_position) + " WHERE rowid = " + String.valueOf(update_bodies_current_row) + "";
                    stmt.executeUpdate(update_body_y_position_query);
                    update_bodies_current_row = update_bodies_current_row + 1;
                }
                else {
                    update_bodies_current_row = update_bodies_current_row + 1;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
