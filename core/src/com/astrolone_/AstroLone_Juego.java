package com.astrolone_;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Graphics.Monitor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import Menus.PauseMenu;
import Objetos.Puntuacion;


public class AstroLone_Juego extends Game {

	public static AstroLone_Juego INSTANCE;
	private int widthScreen, heigtScreen;
	private OrthographicCamera camara;
	private Viewport viewport;

	public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;

    private boolean fullScreen = false;

    private String username;

    private Skin skin;

	public AstroLone_Juego(String username) {
		INSTANCE=this;
		this.username = username;
	}

	@Override
	public void create() {
		this.widthScreen = Gdx.graphics.getWidth();
		this.heigtScreen = Gdx.graphics.getHeight();
		//this.camara.setToOrtho(false, widthScreen, heigtScreen);

		this.camara = new OrthographicCamera(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.camara.position.set(DEFAULT_WIDTH/2f, DEFAULT_HEIGHT/2, 0);
        this.viewport = new StretchViewport(DEFAULT_WIDTH, DEFAULT_HEIGHT, camara);

        this.skin = new Skin(Gdx.files.classpath("widgets/uiskin.json"));
        //Skin skin2 = getDefaultSkin() ;
        //cambiar constructor de patalla de juego
        this.setScreen(new MenuPrincipal(this));

       }

	// Additional method to access the username
    public String getUsername() {
        return username;
    }

	public Viewport getViewport() {
		// TODO Auto-generated method stub
		return this.viewport;
	}

	public Skin getDefaultSkin() {
        return skin;
    }

	public Camera getCamera()
	{
		return camara;
	}

	// establece el modo gráfico a ventana completa
    // utilizando la resolución actual del escritorio
    public void setFullscreen() {
        Monitor currMonitor = Gdx.graphics.getPrimaryMonitor();
        DisplayMode displayMode = Gdx.graphics.getDisplayMode(currMonitor);

        if(!Gdx.graphics.setFullscreenMode(displayMode)) {
            Gdx.app.log(AstroLone_Juego.class.getName(), "Could not change screen mode to full screen");
        } else {
            fullScreen = true;
        }
    }

    // establece el modo en ventana utilizando
    // el modo por defecto
    public void setWindowed() {
        Gdx.graphics.setWindowedMode(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        fullScreen = false;
    }

    // indica si el modo está establecido en pantalla completa
    public boolean isFullScreen() {
        return fullScreen;
    }

    @Override
    public void resize (int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
    
        skin.dispose();
    }



}
