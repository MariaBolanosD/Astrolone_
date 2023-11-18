package MainGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Graphics.Monitor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.astrolone_.PantallaDeJuego;

public class MainGame extends Game{

	public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;
    
    private Skin skin;

    // indica si el juego se encuentra o no en modo ventana
    private boolean fullScreen = false;

    // viewport utilizado en las diferentes pantallas del juego
    private Viewport viewport;

	@Override
	public void create() {
		 // viewport por defecto que puede ser reutilizado
        viewport = new FitViewport(800, 600);
        
        skin = new Skin(Gdx.files.internal("widgets/uiskin.json"));
        
        //cambiar constructor de patalla de juego
        this.setScreen(new PantallaDeJuego(this));
	}

	public Viewport getViewport() {
		// TODO Auto-generated method stub
		return this.viewport;
	}
	 
	public Skin getDefaultSkin() {
        return skin;
    }

	// establece el modo gráfico a ventana completa
    // utilizando la resolución actual del escritorio
    public void setFullscreen() {
        Monitor currMonitor = Gdx.graphics.getPrimaryMonitor();
        DisplayMode displayMode = Gdx.graphics.getDisplayMode(currMonitor);
        
        if(!Gdx.graphics.setFullscreenMode(displayMode)) {
            Gdx.app.log(MainGame.class.getName(), "Could not change screen mode to full screen");
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
    public void dispose() {
        skin.dispose();
    }
	
}
