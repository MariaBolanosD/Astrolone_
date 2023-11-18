package Menus;

import com.astrolone_.PantallaDeJuego;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import MainGame.MainGame;

public class PauseMenu extends ScreenAdapter{

	
	 private final MainGame game;
    
	 
	  private Stage stage;
	  private Table table;
	 
	 public PauseMenu(MainGame game) {
		 this.game = game;
	        
	        
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
	     
	  // creamos un widget de tipo botón con el skin cargado anteriormente
	  // el widget se añade a la tabla con unos tamaños mínimos y con un
	  // espacio (padding) superior e inferior para situarlo un poco
	  final CheckBox fullScreenCheck = new CheckBox("Fullscreen", game.getDefaultSkin());
	  table.add(fullScreenCheck).minWidth(200).padTop(100).padBottom(25);

	  // establecemos el check box del modo gráfico al modo actual
	  fullScreenCheck.setChecked(game.isFullScreen());
	  
	// añadimos un segundo botón para volver al menú principal
      final TextButton exitButton = new TextButton("Return", game.getDefaultSkin());
      table.row();
      table.add(exitButton).minWidth(200);
	     
      exitButton.addListener(new ChangeListener() {

			public void changed (ChangeEvent event, Actor actor) {
				PauseMenu.this.dispose();
				PauseMenu.this.game.setScreen(new PantallaDeJuego(PauseMenu.this.game));

              if (fullScreenCheck.isChecked() && !PauseMenu.this.game.isFullScreen()) {
            	  PauseMenu.this.game.setFullscreen();
              }

              if (!fullScreenCheck.isChecked() && PauseMenu.this.game.isFullScreen()) {
            	  PauseMenu.this.game.setWindowed();
              }
			}
          
		});
      
      
	 }
    
    
	
}
