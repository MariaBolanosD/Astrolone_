package com.astrolone_;

import java.util.ArrayList;
import java.util.random.RandomGenerator;
import java.security.SecureRandom;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Enemies extends ApplicationAdapter {
		   private Texture bucketImage;
		   private SpriteBatch batch;
		   private OrthographicCamera camera;
		   private Sprite sprite_enemy;
		   private ArrayList<Sprite> Enemy;
		   @Override
		   public void create() {
		      // load the images for the droplet and the bucket, 64x64 pixels each
		      bucketImage = new Texture(Gdx.files.internal("droplet.png"));

		      // create the camera and the SpriteBatch
		      camera = new OrthographicCamera();
		      camera.setToOrtho(false, 800, 480);
		      batch = new SpriteBatch();
		      // create a Rectangle to logically represent the bucket
	
		      sprite_enemy = new Sprite(bucketImage);
		      sprite_enemy.setScale(0.2f);
		      
		      

		   }
		   
		   public ArrayList<Sprite> Enemy_Generator(int enemy_count)
		   {
			   ArrayList<Sprite> enemies= new ArrayList<Sprite>();
			   for (int i =0; i < enemy_count; i++)
			   {
				   bucketImage = new Texture(Gdx.files.internal("droplet.png"));
				   Sprite enemy = new Sprite(bucketImage);
				   enemy.setScale(0.2f);
				   enemies.add(enemy);
			   }
			   return enemies;
 		   }
		   
		   public ArrayList<Sprite> Enemy_RandLocation(ArrayList<Sprite> enemy)
		   {
			   SecureRandom rand = new SecureRandom();
			   int upperbound = 20;
			   
			   for(int i = 0 ; i< enemy.size();i++)
			   {
				   int randX = rand.nextInt(upperbound); 
				   int randY = rand.nextInt(upperbound);
				   enemy.get(i).setPosition(randX, randY);
			   }
			   
			   return enemy;
		   }
		   
		   @Override
		   public void render() {

		      camera.update();
		      batch.setProjectionMatrix(camera.combined);

		      batch.begin();
		      sprite_enemy.draw(batch);
		     
		      Enemy =  Enemy_Generator(4);
		      Enemy = Enemy_RandLocation(Enemy);
		      for (Sprite sprite : Enemy) {
				sprite.draw(batch);
			}
		      batch.end();

		    
		   }

		   @Override
		   public void dispose() {
		      // dispose of all the native resources
		      bucketImage.dispose();
		      batch.dispose();
		   }
}
