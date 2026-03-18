package strategy4.jogo;

public class Mecha {

	private Modo modo;

	public Mecha(Modo modo) {
		this.modo = modo;
	}

	public void mover(int x, int y) throws Exception {
		modo.mover(x, y);
	}



	
}
