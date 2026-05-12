package decorator2;

public class Pedido implements PedidoComponente {

	private double total;
	private String estado;

	public Pedido(double total) {
		this.total = total;
		this.estado = "Aberto";
	}
	
	public void concluir() {
		this.estado = "Concluido";
		// eh soh um exemplo... aqui cabe a aplicacao do padrao State
	}

	public double getTotal() {
		return this.total;
	}

}
