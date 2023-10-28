package com.astrolone_;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class AstroLone_Juego extends Game {

	public static AstroLone_Juego INSTANCE;
	private int widthScreen, heigtScreen;
	private OrthographicCamera camara;
	
	
	public AstroLone_Juego() {
		INSTANCE=this;
	}
	
	@Override
	public void create() {
		this.widthScreen = Gdx.graphics.getWidth();
		this.heigtScreen = Gdx.graphics.getHeight();
		this.camara = new OrthographicCamera();
		this.camara.setToOrtho(false, widthScreen, heigtScreen);
		setScreen(new PantallaDeJuego(camara));
	}

}
