package com.astrolone_;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuPrincipal extends ScreenAdapter{

	 private final AstroLone_Juego game;
	
	  private Stage stage;
	  private Table table;

	  public MenuPrincipal(AstroLone_Juego game)
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

		     final Window textArea = new Window("Menu Principal", game.getDefaultSkin());
		     table.row();
		     table.add(textArea).center();

		     // añadimos un segundo botón para volver al menú principal
		     final TextButton exitButton = new TextButton("Start Game", game.getDefaultSkin());
		     table.row();
		     table.add(exitButton).minWidth(200).padTop(100);

		     exitButton.addListener(new ChangeListener() {

				@Override
				public void changed (ChangeEvent event, Actor actor) {
					MenuPrincipal.this.dispose();
					MenuPrincipal.this.game.setScreen(new PantallaDeJuego(MenuPrincipal.this.game));


				}

			});


		 }

		// este método actualiza el viewport cuando se ajusta
		    // el tamaño de la ventana
		    @Override
		    public void resize(int width, int height) {
		        stage.getViewport().update(width, height, true);
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
