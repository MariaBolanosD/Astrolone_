package Menus;

import com.astrolone_.AstroLone_Juego;
import com.astrolone_.MenuPrincipal;
import com.astrolone_.PantallaDeJuego;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;



public class PauseMenu extends ScreenAdapter{

	
	 private final AstroLone_Juego game;
    
	 
	  private Stage stage;
	  private Table table;
	 
	 public PauseMenu(AstroLone_Juego game) 
	 {
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
	     
	     final Window textArea = new Window("Menu Pausa", game.getDefaultSkin());
	     table.row();
	     table.add(textArea).center();
	     table.row();
	     
	     //dkjgad kjasd
	     
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
	     
	     // añadimos un segundo botón para volver al menú principal
	     final TextButton mainMenuButonButton = new TextButton("Main Menu", game.getDefaultSkin());
	     table.row();
	     table.add(mainMenuButonButton).minWidth(200);
	     
	     
	     exitButton.addListener(new ChangeListener() {

			public void changed (ChangeEvent event, Actor actor) {
				PauseMenu.this.dispose();
				PauseMenu.this.game.setScreen(new PantallaDeJuego(PauseMenu.this.game));

             
			}
          
		});
	     
	     mainMenuButonButton.addListener(new ChangeListener() {

				public void changed (ChangeEvent event, Actor actor) {
					PauseMenu.this.dispose();
					PauseMenu.this.game.setScreen(new MenuPrincipal(PauseMenu.this.game));

	             
				}
	          
			});
	     
	     fullScreenCheck.addListener(new ChangeListener() {
	    	 
	    	 public void changed (ChangeEvent event, Actor actor) {
	    		 
	    	 
	    		 if (fullScreenCheck.isChecked() && !PauseMenu.this.game.isFullScreen()) {
	    			 PauseMenu.this.game.setFullscreen();
	    		 }

	    		 if (!fullScreenCheck.isChecked() && PauseMenu.this.game.isFullScreen()) {
	    			 PauseMenu.this.game.setWindowed();
	    		 }
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
