package com.astrolone_;

import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
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
	private Box2DDebugRenderer box2DDebugRenderer;

	private AstroLone_Juego game;
	private static final String SCREEN_NAME = "Game Screen";
	private Stage stage;
	private static final String CONFIG_FILE_PATH = "config.properties";

	private Jugador jugador;
	private EnemyBatch enemy;
	private ArrayList<Disparo> disparos;
	private ArrayList<Enemies> enemigos;
	private static final float TIEMPO_ESPERA_DISPARO = 0.3f;
	private float esperaDeDisparo = 0;
	
	private BitmapFont fuentePuntuacion;
	private int puntuacion;
	private Music backgroundMusic;

	private Sound shootingSound;

//	public PantallaDeJuego(OrthographicCamera camara) {
//		this.camara = camara;
//		this.batch = new SpriteBatch();
//		this.mundo = new World(new Vector2(0, 0), false);
//		this.box2DDebugRenderer = new Box2DDebugRenderer();
//	}

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
		this.box2DDebugRenderer = new Box2DDebugRenderer();

		game.setBackgroundMusic(Gdx.audio.newMusic(Gdx.files.internal("Wizario4.wav")));

		  // Set music to loop
        game.getBackgroundMusic().setLooping(true);

        // Start playing the music
        try {
            game.getGameProperties().load(Gdx.files.internal(CONFIG_FILE_PATH).reader());
            game.setVolume(Float.parseFloat(game.getGameProperties().getProperty("volume")));
		} catch (IOException e) {
            e.printStackTrace();
        }
		
       	game.getBackgroundMusic().play();
        shootingSound = Gdx.audio.newSound(Gdx.files.internal("shoot.mp3"));
		
		
		BodyDef bDef = new BodyDef(); bDef.type = BodyDef.BodyType.DynamicBody;
		this.jugador = new Jugador(2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 50, 50, new Texture(Gdx.files.internal("naveJugador.png")));
		this.enemy = new EnemyBatch();
		this.disparos = new ArrayList<>();
		
		this.fuentePuntuacion = new BitmapFont(Gdx.files.classpath("fuentes/score.fnt"));
		puntuacion = 0;
		 this.enemigos = enemy.getEnemies();

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
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && TIEMPO_ESPERA_DISPARO<=esperaDeDisparo) {
			esperaDeDisparo=0;
			shootingSound.play();
			Vector3 ldCoordinates = game.getCamera().unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
			disparos.add(new Disparo(jugador.getPosicionX(),jugador.getPosicionY(), ldCoordinates.x,ldCoordinates.y));
		}

		ArrayList<Disparo> disparosBorrar = new ArrayList<>();
		ArrayList<Enemies> enemigosBorrar = new ArrayList<>();
		for(Disparo disparo : disparos) {
			disparo.update(Gdx.graphics.getDeltaTime());
			if (disparo.borrar) {
				disparosBorrar.add(disparo);
			}
		}
		
		
		disparos.removeAll(disparosBorrar);
		
		for(Enemies enemi:enemigos)
		{
			enemi.update(Gdx.graphics.getDeltaTime());
			if(enemi.isBorrado()) {
				enemigosBorrar.add(enemi);
			}
		}
		
		//Despues de actualizar todo, mirar si hay colisiones 
		
		for(Disparo d : disparos) {
			for(Enemies e : enemigos) {
				if(d.getReac().colisionAncho(e.getReac())) {
					d.borrar = true;
					enemy.updateSingleEnemyPosition(e);
					puntuacion = puntuacion+100;
				}
				
				
			}
		}
		
		disparos.removeAll(disparosBorrar);
		enemigos.removeAll(enemigosBorrar);
	}




	@Override
	public void render(float delta) {
		this.update();
		esperaDeDisparo+=delta;
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		//Render de objetos
		
		GlyphLayout puntuacionLayout = new GlyphLayout(fuentePuntuacion, ""+puntuacion);
		fuentePuntuacion.draw(batch, puntuacionLayout, AstroLone_Juego.DEFAULT_WIDTH-puntuacionLayout.width - 10, AstroLone_Juego.DEFAULT_HEIGHT-puntuacionLayout.height);
		jugador.draw(batch);
		for (Disparo disparo : disparos) {
			disparo.render(batch);
		}

		for(Enemies en : enemy.getEnemies())
		{
			en.render(batch);
			
		}


		batch.end();


	}

	public int getPuntuacion() {
		return puntuacion;
	}

	@Override
	public void dispose() {
		game.getBackgroundMusic().stop();
		game.getBackgroundMusic().dispose();
	    if (shootingSound != null) {
            shootingSound.dispose();
        }
		Puntuacion p = new Puntuacion(puntuacion, AstroLone_Juego.INSTANCE.getUsername());
		p.guardarPuntuacion();
		Gdx.app.log(SCREEN_NAME, "Se a guardado la puntuacion");
		super.dispose();
	}

	
	
	



}
