package com.astrolone_;

import java.util.ArrayList;
import java.security.SecureRandom;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.ScreenUtils;

public class Enemies extends ApplicationAdapter {
		   private Texture bucketImage;
		   private SpriteBatch batch;
		   private OrthographicCamera camera;
		   private Sprite sprite_enemy;
		   private ArrayList<Sprite> Enemy;
		   private float timer;
		   private int enemy_count = 4;

		  private int counter =0;
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
		   
		   public ArrayList<Sprite> Enemy_Generator( float enemy_spawm_Timer)
		   {
			   ArrayList<Sprite> enemies= new ArrayList<Sprite>();
			   for (int i =0; i < enemy_count; i++)
			   {
				   if(timer > enemy_spawm_Timer && counter<4)
				   {
					   bucketImage = new Texture(Gdx.files.internal("droplet.png"));
					   Sprite enemy = new Sprite(bucketImage);
					   enemy.setScale(0.2f);
					   enemies.add(enemy);
					   counter +=1;
					   timer = 0;
				   }
				  
				   System.out.println(timer);
			   }
			   return enemies;
 		   }
		   
		   public ArrayList<Sprite> Enemy_RandLocation(ArrayList<Sprite> enemy)
		   {
			   int posMax_X = 800/2;
			   int posMin_X = -(800/2);
			   int posMax_Y = 480/2;
			   int posMin_Y = -(480/2);
			   
			   for(int i = 0 ; i< enemy.size();i++)
			   {
				   int randX = (int)Math.floor(Math.random() * (posMax_X - posMin_X + 1) + posMin_X);
				   int randY = (int)Math.floor(Math.random() * (posMax_Y - posMin_Y + 1) + posMin_Y);
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
		      timer += 0.1;
		      Enemy =  Enemy_Generator(5.0f);
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
