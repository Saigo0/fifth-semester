package ex04;
import ex04.pedido.ItemPedido;
import ex04.pedido.PedidoV2;
import ex04.pedido.Produto;
import ex04.strategy.CalculoComum;
import ex04.strategy.CalculoSedex;
import ex04.strategy.CalculoTransportadora;

public class SistemaV2 {

	public static void main(String[] args) throws Exception {

		Produto p1 = new Produto("Chocolate", 0.1, 0.01);
		Produto p2 = new Produto("Leite", 1, 0.3);
		
		PedidoV2 pv2 = new PedidoV2(new CalculoSedex());
		pv2.addItemPedido(new ItemPedido(p1, 10, 0.9));
		pv2.addItemPedido(new ItemPedido(p2, 24, 1.5));
		System.out.println(pv2.calcularFrete());
		
		PedidoV2 pv2_2 = new PedidoV2(new CalculoTransportadora());
		pv2_2.addItemPedido(new ItemPedido(p1, 10, 0.9));
		pv2_2.addItemPedido(new ItemPedido(p2, 24, 1.5));
		System.out.println(pv2_2.calcularFrete());
		
		PedidoV2 pv2_3 = new PedidoV2(new CalculoComum());
		pv2_3.addItemPedido(new ItemPedido(p1, 10, 0.9));
		pv2_3.addItemPedido(new ItemPedido(p2, 24, 1.5));
		System.out.println(pv2_3.calcularFrete());

	}

}
