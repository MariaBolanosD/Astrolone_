package Objetos;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class EntidadEspacial {
	
	protected float x, y, velX, VelY, velocidad;
	protected float	largura, altura;
	protected Body cuerpo;
	
	public EntidadEspacial(float largura, float altura, Body cuerpo) {
		this.x = cuerpo.getPosition().x;
		this.y = cuerpo.getPosition().y;
		this.largura = largura;
		this.altura = altura;
		this.cuerpo = cuerpo;
		this.velX = 0f;
		this.VelY = 0f;
		this.velocidad = 0f;
		
	}
	
	
	public abstract void  update();
	
	public abstract void render(SpriteBatch batch);
	
	public Body getBody() {
		return cuerpo;
	}


	public float getX() {
		return x;
	}


	public float getY() {
		return y;
	}
	
	
	
	
}
