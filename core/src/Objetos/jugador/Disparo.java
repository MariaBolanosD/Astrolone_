package Objetos.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Disparo {
	
	public static int velocidad = 500;
	private static Texture textura;
	
	float x,y;
	float ratonX,ratonY;
	float velX,velY;
	
	public boolean borrar = false;
	
	public Disparo(float x, float y,float ratonX, float ratonY) {
		this.x = x;
		this.y = y;
		this.ratonX = ratonX;
		this.ratonY = ratonY;
		
		
		
		//float distanciaCat = ;
		this.velY = -calculoVel(this.y, this.ratonY);
		this.velX = -calculoVel(this.x, this.ratonX);
		
		if (textura == null) {
			textura = new Texture(Gdx.files.internal("disparo.png"));
			
		}
	}
	
	private float calculoVel(float origen, float destino) {
		System.out.println(ratonY);
		return distancia(origen, destino)/pitagoras(x, y, ratonX, ratonY);
		
		
	}
	
	
	private float pitagoras(float x, float y, float ratonX, float ratonY) {
		return (float) (Math.sqrt(Math.pow(distancia(x, ratonX), 2) + Math.pow(distancia(y, ratonY), 2)));
	}
	
	private float distancia(float origen, float destino) {
		//return (float) (Math.sqrt(Math.pow(origen, 2) + Math.pow(destino, 2)));
		return (float) (origen-destino);
	}

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
