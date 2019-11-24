package com.naglfar_package;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Draw_Background {
    static void draw_background(){
        Gdx.gl.glClearColor(0, 0, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
