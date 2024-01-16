package Menus;

import java.io.IOException;
import java.util.Properties;

import com.astrolone_.AstroLone_Juego;
import com.astrolone_.MenuPrincipal;
import com.astrolone_.PantallaDeJuego;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;


// imports para .properties

public class PauseMenu extends ScreenAdapter{

	 private final AstroLone_Juego game;
	// private final Properties properties;

	 //private static final String CONFIG_FILE_PATH = "resources/config.properties";
	 private CheckBox fullscreenCheckBox;
	 
	  private Stage stage;
	  private Table table;

	 public PauseMenu(final AstroLone_Juego game)
	 {
		 this.game = game;

		// Load properties
	    	 
		 
	     // se hace uso del grafo de escena
	     // para establecer los widgets
	     stage = new Stage(game.getViewport());
	     Gdx.input.setInputProcessor(stage);

	     // la distribución de los widgets en la pantalla se van a
	     // distribuir utilizando una tabla que ocupa todo el espacio
	     table = new Table();
	     table.setFillParent(true);

	     // añadimos la tabla al grafo de escena
	     stage.addActor(table);

	     final Window textArea = new Window("Menu Pausa", game.getDefaultSkin());
	     table.row();
	     table.add(textArea).center();
	     table.row();

	     // creamos un widget de tipo botón con el skin cargado anteriormente
	     // el widget se añade a la tabla con unos tamaños mínimos y con un
	     // espacio (padding) superior e inferior para situarlo un poco
	     boolean fullscreen = Boolean.parseBoolean(game.getGameProperties().getProperty("fullscreen"));
	     fullscreenCheckBox = new CheckBox("Fullscreen", game.getDefaultSkin());
	     fullscreenCheckBox.setChecked(fullscreen);
	     table.add(fullscreenCheckBox).minWidth(200).padTop(100).padBottom(25);

	     // establecemos el check box del modo gráfico al modo actual
	     fullscreenCheckBox.setChecked(game.isFullScreen());

	     // añadimos un segundo botón para volver al menú principal
	     final TextButton exitButton = new TextButton("Return", game.getDefaultSkin());
	     table.row();
	     table.add(exitButton).minWidth(200);

	     // añadimos un segundo botón para volver al menú principal
	     final TextButton mainMenuButonButton = new TextButton("Main Menu", game.getDefaultSkin());
	     table.row();
	     table.add(mainMenuButonButton).minWidth(200);

	     
	     final TextButton quitMenuButonButton = new TextButton("Quit", game.getDefaultSkin());
	     table.row();
	     table.add(quitMenuButonButton).minWidth(200);
	     
	     exitButton.addListener(new ChangeListener() {

			@Override
			public void changed (ChangeEvent event, Actor actor) {
				PauseMenu.this.dispose();
				
				PauseMenu.this.game.setScreen(new PantallaDeJuego(PauseMenu.this.game));
			}

		});

	     mainMenuButonButton.addListener(new ChangeListener() {

				@Override
				public void changed (ChangeEvent event, Actor actor) {
					PauseMenu.this.dispose();
					PauseMenu.this.game.setScreen(new MenuPrincipal(PauseMenu.this.game));
				}

			});
	     
	     quitMenuButonButton.addListener(new ChangeListener() {

				@Override
				public void changed (ChangeEvent event, Actor actor) {
					PauseMenu.this.dispose();
					game.saveGameProperties();
					Gdx.app.exit();
				}

			});

	     fullscreenCheckBox.addListener(new ChangeListener() {

	    	 @Override
			public void changed (ChangeEvent event, Actor actor) {

	    		 boolean isChecked = fullscreenCheckBox.isChecked();
	    		 if (fullscreenCheckBox.isChecked() && !PauseMenu.this.game.isFullScreen()) {
	    			 PauseMenu.this.game.setFullscreen();
	    		 }

	    		 if (!fullscreenCheckBox.isChecked() && PauseMenu.this.game.isFullScreen()) {
	    			 PauseMenu.this.game.setWindowed();
	    		 }
	    		 
	    		 game.getGameProperties().setProperty("fullscreen", String.valueOf(isChecked));
	    		 game.saveGameProperties();
	    	 }

	     });

	 }

	// este método actualiza el viewport cuando se ajusta
	    // el tamaño de la ventana
	    @Override
	    public void resize(int width, int height) {
	        stage.getViewport().update(width, height, false);
	    }

	    @Override
	    public void render(float delta) {
	        ScreenUtils.clear(0, 0, 0, 1);

	        // aquí hacemos uso del grafo de escena para
	        // los widgets
	        stage.act(delta);
	        stage.draw();
	    }

	    // método para destruir los recursos cargados
	    // para esta pantalla.
	    @Override
	    public void dispose() {
	        stage.dispose();
	    }



}
