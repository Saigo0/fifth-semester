package ex04;
import ex04.pedido.ItemPedido;
import ex04.pedido.PedidoV1;
import ex04.pedido.PedidoV2;
import ex04.pedido.Produto;
import ex04.strategy.CalculoSedex;
import ex04.strategy.CalculoTransportadora;
import ex04.strategy.EFrete;

public class SistemaV1 {

	public static void main(String[] args) throws Exception {

		Produto p1 = new Produto("Chocolate", 0.1, 0.01);
		Produto p2 = new Produto("Leite", 1, 0.3);
		
		PedidoV1 pv1 = new PedidoV1(EFrete.SEDEX);
		pv1.addItemPedido(new ItemPedido(p1, 10, 0.9));
		pv1.addItemPedido(new ItemPedido(p2, 24, 1.5));
		System.out.println(pv1.calcularFrete());
		
		PedidoV1 pv1_2 = new PedidoV1(EFrete.TRANSPORTADORA);
		pv1_2.addItemPedido(new ItemPedido(p1, 10, 0.9));
		pv1_2.addItemPedido(new ItemPedido(p2, 24, 1.5));
		System.out.println(pv1_2.calcularFrete());

		PedidoV1 pv1_3 = new PedidoV1(EFrete.COMUM);
		pv1_3.addItemPedido(new ItemPedido(p1, 10, 0.9));
		pv1_3.addItemPedido(new ItemPedido(p2, 24, 1.5));
		System.out.println(pv1_3.calcularFrete());
	}

}
