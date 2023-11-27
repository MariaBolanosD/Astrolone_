package Objetos.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Disparo {
	
	public static int velocidad = 500;
	private static Texture textura;
	
	float x,y,poxX,poY;
	int velX,velY;
	
	public boolean borrar = false;
	
	public Disparo(float x, float y) {
		this.x = x;
		this.y = y;
		this.velY = 1;
		this.velX = 1;
		
		if (textura == null) {
			textura = new Texture(Gdx.files.internal("disparo.png"));
		}
	}
	
//	private void calculoVelX(float x, float y, float ratonY) {
//	}
//	
//	
//	private float distancia(float x, float y) {
//	}
	

	public void update (float deltaTime) {
		y += velocidad * velY * deltaTime;
		x += velocidad * velX * deltaTime;
		
		if (y > Gdx.graphics.getBackBufferHeight()+ 300) {
			borrar = true;
		}
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(textura,x,y);
	}
	
	
	
}
