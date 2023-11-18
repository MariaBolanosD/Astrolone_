package com.astrolone_;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import MainGame.MainGame;
import ayudas.Constantes;

public class PantallaDeJuego extends ScreenAdapter{
	
	private OrthographicCamera camara;
	private SpriteBatch batch;
	private World mundo;
	private Box2DDebugRenderer box2DDebugRenderer;
	
	public PantallaDeJuego(OrthographicCamera camara) {
		this.camara = camara;
		this.batch = new SpriteBatch();
		this.mundo = new World(new Vector2(0, 0), false);
		this.box2DDebugRenderer = new Box2DDebugRenderer();
	}

	public PantallaDeJuego(MainGame game) {
		// TODO Auto-generated constructor stub
	}

	private void update() {
		mundo.step(1/60, 6, 2);
		
		batch.setProjectionMatrix(camara.combined);
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			Gdx.app.exit();
		}
	}
	
	private void updateCamara() {
		camara.position.set(new Vector3(0,0,0));
		camara.update();
	}
	
	
	@Override
	public void render(float delta) {
		this.update();
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		//Render de objetos
		
		
		
		batch.end();
		
		box2DDebugRenderer.render(mundo, camara.combined.scl(Constantes.pixelesPorMetro));
		
	}
	
	
	

}
