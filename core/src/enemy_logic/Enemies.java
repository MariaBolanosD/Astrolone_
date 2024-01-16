package enemy_logic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemies extends ApplicationAdapter {
		   private Texture bucketImage;
		   private SpriteBatch batch;
		   private float Scale  = 0.2f;
		   private Sprite sprite_enemy;
		   private int posX;
		   private int posY;

		   public  Enemies()
		   {
			   setBucketImage(new Texture(Gdx.files.internal("droplet.png")));
			    
			      // create a Rectangle to logically represent the bucket
		
			   setSprite_enemy(new Sprite(getBucketImage()));
			   getSprite_enemy().setScale(Scale);
		   }

		   @Override
		   public void create() {
		      // load the images for the droplet and the bucket, 64x64 pixels each
		      setBucketImage(new Texture(Gdx.files.internal("droplet.png")));
    
		      // create a Rectangle to logically represent the bucket
	
		      setSprite_enemy(new Sprite(getBucketImage()));
		      getSprite_enemy().setScale(Scale);



		   }
		   
		   public void render(SpriteBatch batch) {

		      getSprite_enemy().draw(batch);
//		      timer += 0.1;
//		      Enemy =  Enemy_Generator(5.0f);
//		      Enemy = Enemy_RandLocation(Enemy);
//		      for (Sprite sprite : Enemy) {
//				sprite.draw(batch);}

		   }

	
		   @Override
		   public void dispose() {
		      // dispose of all the native resources
		      getBucketImage().dispose();
		      batch.dispose();
		   }



		public Texture getBucketImage() {
			return bucketImage;
		}

		public void setBucketImage(Texture bucketImage) {
			this.bucketImage = bucketImage;
		}

		public Sprite getSprite_enemy() {
			return sprite_enemy;
		}

		public void setSprite_enemy(Sprite sprite_enemy) {
			this.sprite_enemy = sprite_enemy;
		}
		
		
		public int getPosX_enemy() {
			return posX;
		}

		public void setPosX_enemy(int posX) {
			this.posX = posX;
		}
		
		public int getPosY_enemy() {
			return posY;
		}

		public void setPosY_enemy(int posY) {
			this.posY = posY;
		}
}