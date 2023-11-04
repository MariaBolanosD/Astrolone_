package com.astrolone_;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class Drop extends ApplicationAdapter {
   private Texture bucketImage;
   private SpriteBatch batch;
   private OrthographicCamera camera;
   private Sprite sprite;
   @Override
   public void create() {
      // load the images for the droplet and the bucket, 64x64 pixels each
      bucketImage = new Texture(Gdx.files.internal("droplet.png"));

      // create the camera and the SpriteBatch
      camera = new OrthographicCamera();
      camera.setToOrtho(false, 800, 480);
      batch = new SpriteBatch();
      // create a Rectangle to logically represent the bucket
     
    //  bucket.setSize(2);
      sprite = new Sprite(bucketImage);
      sprite.setScale(0.5f);
      
      

   }

   @Override
   public void render() {
      // clear the screen with a dark blue color. The
      // arguments to clear are the red, green
      // blue and alpha component in the range [0,1]
      // of the color to be used to clear the screen.
      ScreenUtils.clear(0, 0, 0.2f, 1);

      // tell the camera to update its matrices.
      camera.update();

      // tell the SpriteBatch to render in the
      // coordinate system specified by the camera.
      batch.setProjectionMatrix(camera.combined);

      // begin a new batch and draw the bucket and
      // all drops
      batch.begin();
      sprite.draw(batch);
      //batch.draw(bucketImage, bucket.x, bucket.y);
      batch.end();

      // process user input
      if(Gdx.input.isKeyPressed(Keys.LEFT)) sprite.setX(sprite.getX() -200 * Gdx.graphics.getDeltaTime());
      if(Gdx.input.isKeyPressed(Keys.RIGHT)) sprite.setX(sprite.getX() +200 * Gdx.graphics.getDeltaTime());

      if(Gdx.input.isKeyPressed(Keys.UP)) sprite.setY(sprite.getY() +200 * Gdx.graphics.getDeltaTime());
      if(Gdx.input.isKeyPressed(Keys.DOWN)) sprite.setY(sprite.getY() -200 * Gdx.graphics.getDeltaTime());
      // make sure the bucket stays within the screen bounds
     // if(bucket.x < 0) bucket.x = 0;
     // if(bucket.x > 800 - 64) bucket.x = 800 - 64;

   }

   @Override
   public void dispose() {
      // dispose of all the native resources
      bucketImage.dispose();
      batch.dispose();
   }
}