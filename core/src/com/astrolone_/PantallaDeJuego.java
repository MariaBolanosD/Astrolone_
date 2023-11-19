package com.astrolone_;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Stage;

import Menus.PauseMenu;
import Objetos.jugador.Jugador;
import Objetos.jugador.Jugador.Direction;
import ayudas.Constantes;

public class PantallaDeJuego extends ScreenAdapter {
	
	//private OrthographicCamera camara;
	private SpriteBatch batch;
	private World mundo;
	private Box2DDebugRenderer box2DDebugRenderer;
	
	private AstroLone_Juego game;
	private static final String SCREEN_NAME = "Game Screen";
	private Stage stage;
	
	private Jugador jugador;
	
//	public PantallaDeJuego(OrthographicCamera camara) {
//		this.camara = camara;
//		this.batch = new SpriteBatch();
//		this.mundo = new World(new Vector2(0, 0), false);
//		this.box2DDebugRenderer = new Box2DDebugRenderer();
//	}

	class KeyboardProcessor extends InputAdapter {

		
		
		@Override
		public boolean keyDown(int keycode) {
			
			switch (keycode) {
			case Keys.LEFT:jugador.setLeftMove(true);
				break;
			case Keys.RIGHT:jugador.setRightMove(true);
				break;
			case Keys.UP:jugador.setUpMove(true);
				break;
			case Keys.DOWN:jugador.setDownMove(true);
				break;
			default:
				break;
			}
			
			
			return super.keyDown(keycode);
		}
		
		@Override
		public boolean keyUp(int key) {			
			switch (key) {
			
				case Keys.LEFT:		jugador.setLeftMove(false);
									break;
				case Keys.RIGHT:	jugador.setRightMove(false);
									break;
				case Keys.UP:		jugador.setUpMove(false);
									break;
				case Keys.DOWN:		jugador.setDownMove(false);
									break;
				case Keys.ESCAPE:	toPauseScreen();
									break;
				case Keys.F:		toogleFullScreen();
									break;
				default:			break;
			}

			return false;
		}
		
		private void toogleFullScreen() {
			if (game.isFullScreen()) {
				game.setWindowed();
			} else {
				game.setFullscreen();
			}
		}
		
		public void toPauseScreen() {
			game.getScreen().dispose();
			game.setScreen(new PauseMenu(game));
		}
	}
	
	public PantallaDeJuego(AstroLone_Juego game) {		
		this.game = game;
		
		this.batch = new SpriteBatch();
		this.mundo = new World(new Vector2(0, 0), false);
		this.box2DDebugRenderer = new Box2DDebugRenderer();

		BodyDef bDef = new BodyDef(); bDef.type = BodyDef.BodyType.DynamicBody;
		this.jugador = new Jugador(20, 20, mundo.createBody(bDef));
		
		Gdx.app.log(SCREEN_NAME, "Iniciando screen principal del juego");
		
		stage = new Stage(game.getViewport());
		
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(stage);
		multiplexer.addProcessor(new KeyboardProcessor());
		
		// registramos el multiplexador de eventos como escuchador
		Gdx.input.setInputProcessor(multiplexer);
	}

	private void update() {
		mundo.step(1/60, 6, 2);
		jugador.update();
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
		//box2DDebugRenderer.render(mundo, game.getCamera().combined.scl(Constantes.pixelesPorMetro));
		
		jugador.render(batch);
		
		batch.end();
		
		
	}
	
	

}
