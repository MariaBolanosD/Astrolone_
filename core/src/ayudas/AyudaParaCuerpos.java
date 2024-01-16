package ayudas;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


public class AyudaParaCuerpos {
	
	public static Body crearCuerpo(float x, float y, float width, float heigth, boolean isStatic, World mundo){
		BodyDef defCuerpo = new BodyDef();
		
		defCuerpo.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
		defCuerpo.position.set(x/Constantes.pixelesPorMetro, y/Constantes.pixelesPorMetro);
		Body cuerpo = mundo.createBody(defCuerpo);
		
		PolygonShape forma = new PolygonShape();
		forma.setAsBox(width/2/Constantes.pixelesPorMetro, heigth/2/Constantes.pixelesPorMetro);
		
		FixtureDef fixtrueDef = new FixtureDef();
		fixtrueDef.shape = forma;
		cuerpo.createFixture(fixtrueDef);
		forma.dispose();
		return cuerpo;
		
		
		
	}

}
