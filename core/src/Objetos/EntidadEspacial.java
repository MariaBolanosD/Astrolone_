package Objetos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class EntidadEspacial {
	
	float Velocidad;
	protected float posicionX,posicionY;
	protected float ancho,alto;
	
	Texture textura;
	
	

	public EntidadEspacial(float velocidad, float centroX, float centroY, float ancho, float alto,
			Texture textura) {
		this.Velocidad = velocidad;
		this.posicionX = centroX - ancho/2;
		this.posicionY = centroY - alto/2;
		this.ancho = ancho;
		this.alto = alto;
		this.textura = textura;
	}
	
	public void draw(Batch batch) {
		batch.draw(textura, posicionX, posicionY, ancho, alto);
	}

	
	public abstract void update();
	
	    

	public float getPosicionX() {
		return posicionX;
	}

	public float getPosicionY() {
		return posicionY;
	}

	public void setPosicionX(float posicionX) {
		this.posicionX = posicionX;
	}

	public void setPosicionY(float posicionY) {
		this.posicionY = posicionY;
	}
	
	
	

}
