package Objetos.jugador;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import Objetos.EntidadEspacial;
import ayudas.Constantes;



public class Jugador extends EntidadEspacial{

	public enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}
	
	 boolean leftMove;
	 boolean rightMove;
	 boolean downMove;
	 boolean upMove;
	
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
		
		updateMotion();
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	      sprite.draw(batch);
	}
	
	public void updateMotion()
	{
		if (leftMove)
	    {
			sprite.setX(sprite.getX() -200 * Gdx.graphics.getDeltaTime());
	    }
	    if (rightMove)
	    {
	    	sprite.setX(sprite.getX() +200 * Gdx.graphics.getDeltaTime());
	    }
	    if(upMove)
	    {
	    	sprite.setY(sprite.getY() +200 * Gdx.graphics.getDeltaTime());
	    }
	    if(downMove)
	    {
	    	sprite.setY(sprite.getY() -200 * Gdx.graphics.getDeltaTime());
	    }
	    
	}
	
	public void setLeftMove(boolean t)
    {
	    if(rightMove && t) rightMove = false;
	    leftMove = t;
    }
    public void setRightMove(boolean t)
    {
	    if(leftMove && t) leftMove = false;
	    rightMove = t;
    }
    public void setUpMove(boolean t)
    {
	    if(downMove && t) downMove = false;
	    upMove = t;
    }
    public void setDownMove(boolean t)
    {
	    if(upMove && t) upMove = false;
	    downMove = t;
    }
    
}
