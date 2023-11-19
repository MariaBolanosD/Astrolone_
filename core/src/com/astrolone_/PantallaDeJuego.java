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
import com.badlogic.gdx.scenes.scene2d.Stage;

import ayudas.Constantes;

public class PantallaDeJuego extends ScreenAdapter{
	
	//private OrthographicCamera camara;
	private SpriteBatch batch;
	private World mundo;
	private Box2DDebugRenderer box2DDebugRenderer;
	
	private AstroLone_Juego game;
	private static final String SCREEN_NAME = "Game Screen";
	private Stage stage;
	
//	public PantallaDeJuego(OrthographicCamera camara) {
//		this.camara = camara;
//		this.batch = new SpriteBatch();
//		this.mundo = new World(new Vector2(0, 0), false);
//		this.box2DDebugRenderer = new Box2DDebugRenderer();
//	}

	public PantallaDeJuego(AstroLone_Juego game) {		
		this.game = game;
		
		this.batch = new SpriteBatch();
		this.mundo = new World(new Vector2(0, 0), false);
		this.box2DDebugRenderer = new Box2DDebugRenderer();
		
		
		Gdx.app.log(SCREEN_NAME, "Iniciando screen principal del juego");
		
		stage = new Stage(game.getViewport());
	}

	private void update() {
		mundo.step(1/60, 6, 2);
		
		batch.setProjectionMatrix(game.getCamera().combined);
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			Gdx.app.exit();
		}
	}
	
	private void updateCamara() {
		game.getCamera().position.set(new Vector3(0,0,0));
		game.getCamera().update();
	}
	
	
	@Override
	public void render(float delta) {
		this.update();
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		//Render de objetos
		
		
		
		batch.end();
		
		box2DDebugRenderer.render(mundo, game.getCamera().combined.scl(Constantes.pixelesPorMetro));
		
	}
	
	
	

}
