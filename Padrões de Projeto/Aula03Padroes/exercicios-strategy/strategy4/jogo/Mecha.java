package strategy4.jogo;

public class Mecha {

	private Modo modo;
	private int x;
	private int y;

	public Mecha(Modo modo, int x, int y) {
		this.x = x;
		this.y = y;
		this.modo = modo;
	}

	public void mover() throws Exception {
		modo.mover(this);
	}

	public int getX() {
		return x;
	}

	public int getY(){
		return y;
	}

	
}
