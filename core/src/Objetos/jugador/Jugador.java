package Objetos.jugador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import Objetos.EntidadEspacial;
import ayudas.Constantes;



public class Jugador extends EntidadEspacial{

	private Sprite sprite;
	private Texture bucketImage;
	
	public Jugador(float largura, float altura, Body cuerpo) {
		super(largura, altura, cuerpo);
		this.velocidad = 4f;
		
		bucketImage = new Texture(Gdx.files.internal("droplet.png"));
		sprite = new Sprite(bucketImage);
	    sprite.setScale(0.5f);
	}

	@Override
	public void update() {
		x = cuerpo.getPosition().x * Constantes.pixelesPorMetro;
		y = cuerpo.getPosition().y * Constantes.pixelesPorMetro;
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	      sprite.draw(batch);
	}
	
	

}
