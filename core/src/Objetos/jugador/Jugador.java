package Objetos.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import Objetos.EntidadEspacial;



public class Jugador extends EntidadEspacial
{

	private int vida;
	private boolean leftMove,rightMove,upMove,downMove;
	
	public Jugador(float velocidad, float centroX, float centroY, float ancho, float alto, Texture textura) {
		super(velocidad, centroX, centroY, ancho, alto, textura);
		this.vida = 3;
	}

	@Override
	public void update() {
		if (leftMove)
	    {
			setPosicionX(posicionX -200 * Gdx.graphics.getDeltaTime());;
			
	    }
	    if (rightMove)
	    {
	    	setPosicionX(posicionX + 200 * Gdx.graphics.getDeltaTime());
	    	
	    }
	    if(upMove)
	    {
	    	setPosicionY(posicionY + 200 * Gdx.graphics.getDeltaTime());

	    }
	    if(downMove)
	    {
	    	setPosicionY(posicionY - 200 * Gdx.graphics.getDeltaTime());
	    	
	    }
		
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public boolean isLeftMove() {
		return leftMove;
	}

	public void setLeftMove(boolean leftMove) {
		this.leftMove = leftMove;
	}

	public boolean isRightMove() {
		return rightMove;
	}

	public void setRightMove(boolean rightMove) {
		this.rightMove = rightMove;
	}

	public boolean isUpMove() {
		return upMove;
	}

	public void setUpMove(boolean upMove) {
		this.upMove = upMove;
	}

	public boolean isDownMove() {
		return downMove;
	}

	public void setDownMove(boolean downMove) {
		this.downMove = downMove;
	}
	
	

	
}
