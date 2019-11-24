package com.naglfar_package;

import java.sql.SQLException;
import java.sql.Statement;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.sql.ResultSet;
import java.lang.Math;

public class Draw_Bodies {
    static String number_of_bodies_to_draw_query = "SELECT COUNT(*) FROM bodies WHERE parent_system = '" +Naglfar_Main.current_system+ "'";
    static void draw_bodies(){

        Naglfar_Main.shape_renderer.begin(ShapeRenderer.ShapeType.Filled);          //start the begin thingy outside the loop for better performance

        try {
            int draw_bodies_current_row = 1;            //Starts drawing bodies from row 1 of results
            Statement stmt = Connect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(number_of_bodies_to_draw_query);
            int number_of_bodies_to_draw = rs.getInt(1);

            while(draw_bodies_current_row <= number_of_bodies_to_draw) {

                String x_position_query = "SELECT x_position FROM bodies WHERE rowid = " +String.valueOf(draw_bodies_current_row)+ " AND parent_system = '" +Naglfar_Main.current_system+ "'";
                String y_position_query = "SELECT y_position FROM bodies WHERE rowid = " +String.valueOf(draw_bodies_current_row)+ " AND parent_system = '" +Naglfar_Main.current_system+ "'";
                rs = stmt.executeQuery(x_position_query);
                float x_position = rs.getInt(1);
                int x_body_draw = Math.round(x_position);
                rs = stmt.executeQuery(y_position_query);
                float y_position = rs.getInt(1);
                int y_body_draw = Math.round(y_position);

                Naglfar_Main.shape_renderer.setColor(1, 1, 0, 1);
                Naglfar_Main.shape_renderer.circle(x_body_draw, y_body_draw, 10);
                draw_bodies_current_row = draw_bodies_current_row + 1;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Naglfar_Main.shape_renderer.end();          //end the renderer thingy outside the loop for better performance
    }
}
