package com.astrolone_;


import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import Menus.PauseMenu;
import Objetos.Puntuacion;
import Objetos.jugador.Disparo;
import Objetos.jugador.Jugador;
import enemy_logic.Enemies;
import enemy_logic.EnemyBatch;

public class PantallaDeJuego extends ScreenAdapter {

	//private OrthographicCamera camara;
	private SpriteBatch batch;
	private World mundo;
<<<<<<< HEAD
	
	
=======
	private Box2DDebugRenderer box2DDebugRenderer;

>>>>>>> main
	private AstroLone_Juego game;
	private static final String SCREEN_NAME = "Game Screen";
	private Stage stage;

	private Jugador jugador;
	private EnemyBatch enemy;
	private ArrayList<Disparo> disparos;
	private static final float TIEMPO_ESPERA_DISPARO = 0.3f;
	private float esperaDeDisparo = 0;
	
	private BitmapFont fuentePuntuacion;
	private int puntuacion;
	
<<<<<<< HEAD
=======


//	public PantallaDeJuego(OrthographicCamera camara) {
//		this.camara = camara;
//		this.batch = new SpriteBatch();
//		this.mundo = new World(new Vector2(0, 0), false);
//		this.box2DDebugRenderer = new Box2DDebugRenderer();
//	}
>>>>>>> main

	class KeyboardProcessor extends InputAdapter{



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
		this.enemy = new EnemyBatch();
		this.batch = new SpriteBatch();
		this.mundo = new World(new Vector2(0, 0), false);
		

		BodyDef bDef = new BodyDef(); bDef.type = BodyDef.BodyType.DynamicBody;
		this.jugador = new Jugador(2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 50, 50, new Texture(Gdx.files.internal("naveJugador.png")));
		this.enemy = new EnemyBatch();
		this.disparos = new ArrayList<>();
		
		this.fuentePuntuacion = new BitmapFont(Gdx.files.internal("fuentes/score.fnt"));
		puntuacion = 0;
		

		Gdx.app.log(SCREEN_NAME, "Iniciando screen principal del juego");

		stage = new Stage(game.getViewport());

		//enemy.Enemy_Generator(3);

		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(stage);
		multiplexer.addProcessor(new KeyboardProcessor());

		// registramos el multiplexador de eventos como escuchador
		Gdx.input.setInputProcessor(multiplexer);
	}

	private void update() {
		mundo.step(1/60, 6, 2);
		jugador.update();
		

//		for(Enemies enemi:enemy)
//		{
//			enemi.update();
//		}
		batch.setProjectionMatrix(game.getCamera().combined);
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && TIEMPO_ESPERA_DISPARO<=esperaDeDisparo) {
			esperaDeDisparo=0;
			puntuacion = puntuacion+10;
			Vector3 ldCoordinates = game.getCamera().unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
			disparos.add(new Disparo(jugador.getPosicionX(),jugador.getPosicionY(), ldCoordinates.x,ldCoordinates.y));
		}

		ArrayList<Disparo> disparosBorrar = new ArrayList<>();
		for(Disparo disparo : disparos) {
			disparo.update(Gdx.graphics.getDeltaTime());
			if (disparo.borrar) {
				disparosBorrar.add(disparo);
			}
		}
		disparos.removeAll(disparosBorrar);
		
		//Despues de actualizar todo, mirar si hay colisiones 
	}
<<<<<<< HEAD
	
	
	
=======

	private void updateCamara() {
		game.getCamera().position.set(new Vector3(0,0,0));
		game.getCamera().update();
	}


>>>>>>> main
	@Override
	public void render(float delta) {
		this.update();
		esperaDeDisparo+=delta;
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		//Render de objetos
		//box2DDebugRenderer.render(mundo, game.getCamera().combined.scl(Constantes.pixelesPorMetro));
		GlyphLayout puntuacionLayout = new GlyphLayout(fuentePuntuacion, ""+puntuacion);
		fuentePuntuacion.draw(batch, puntuacionLayout, AstroLone_Juego.INSTANCE.DEFAULT_WIDTH-puntuacionLayout.width - 10, AstroLone_Juego.INSTANCE.DEFAULT_HEIGHT-puntuacionLayout.height);
		jugador.draw(batch);
		for (Disparo disparo : disparos) {
			disparo.render(batch);
		}

		for(Enemies en : enemy.getEnemies())
		{
			en.render(batch);
			//System.out.println(2);
			//System.out.println( en.getSprite_enemy().getX());
		}


		batch.end();


	}

	public int getPuntuacion() {
		return puntuacion;
	}

	@Override
	public void dispose() {
		
		Puntuacion p = new Puntuacion(puntuacion, "a");
		p.guardarPuntuacion();
		super.dispose();
	}

	
	
	



}
