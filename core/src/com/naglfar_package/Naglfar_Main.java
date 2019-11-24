package com.naglfar_package;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.ApplicationListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Naglfar_Main extends ApplicationAdapter {

	private SpriteBatch batch;
	private BitmapFont font;
	static ShapeRenderer shape_renderer;
	static String current_system = "Sol";

	@Override
	public void create() {
		shape_renderer = new ShapeRenderer();
		Connect.connect();
		Create_Sol_System.create_sol_bodies_table();
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
	}

	@Override
	public void render() {
		Draw_Background.draw_background();
		Update_Body_Positions.update_body_positions();
		Draw_Bodies.draw_bodies();

		//batch.begin();
		//font.draw(batch, "Hello World", 200, 200);
		//batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
		Disconnect.disconnect();
	}

}
