package enemy_logic;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class EnemyBatch {

	private ArrayList<Enemies> Enemy;
	private float timer;
	private int enemy_count = 4;

	private int counter = 0;

	public EnemyBatch()
	{
		Enemy = new ArrayList<>();
		CreateRandomEnemy();

	}


	public void Enemy_Generator( float enemy_spawm_Timer)
	   {


		    for (int i =0; i < enemy_count; i++)
		    {
		    	Enemies enem = new Enemies();
			   //if(timer > enemy_spawm_Timer && counter<4)
			   {
				   enem.setBucketImage(new Texture(Gdx.files.internal("droplet.png")));
				   Sprite spr = (new Sprite(enem.getBucketImage()));
				   spr.setScale(0.2f);
				   enem.setSprite_enemy(spr);
				   Enemy.add(enem);
				   counter +=1;
				   timer = 0;
			   }

			 //  System.out.println(timer);
		   }
	   }

	  public void CreateRandomEnemy() {
	      timer += 0.1;
	      Enemy_Generator(5.0f);
	     // System.out.println(Enemy.size());
	      Enemy_RandLocation();
	  }

	  public void Enemy_RandLocation()
	   {
		   int posMax_X = 800/2;
		   int posMin_X = -(800/2);
		   int posMax_Y = 480/2;
		   int posMin_Y = -(480/2);

		   for (Enemies element : Enemy) {
			   int randX = (int)Math.floor(Math.random() * (posMax_X - posMin_X + 1) + posMin_X);
			   int randY = (int)Math.floor(Math.random() * (posMax_Y - posMin_Y + 1) + posMin_Y);
			   Sprite spr = element.getSprite_enemy(); spr.setPosition(randX, randY);
			   element.setPosX_enemy(randX);
			   element.setPosY_enemy(randY);
			   element.setSprite_enemy(spr);

		   }
	   }

	  public void dispose()
	  {
		  for(Enemies enem : Enemy)
		  {
			 enem.dispose();
		  }
	  }

	  public ArrayList<Enemies> getEnemies()
	  {
		  return this.Enemy;
	  }
	  
	  
}