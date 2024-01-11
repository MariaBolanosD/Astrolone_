package ayudas;

public class ReaccionColisiones {
	
	float x,y;
	int ancho,alto;
	
	
	public ReaccionColisiones(float x, float y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void mover (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	
	
	public boolean colisionAncho(ReaccionColisiones reac) {
		return x< reac.x + reac.ancho && y < reac.y + reac.alto && x + ancho > reac.x && y + alto > reac.alto;
	}
}
