package ex04.strategy;

import ex04.pedido.ItemPedido;
import ex04.pedido.PedidoV2;

public class CalculoComum implements CalculoFrete {

	@Override
	public double calcular(PedidoV2 pedido) throws Exception {
		double total = 0;
		for (ItemPedido item:pedido.getItensPedido())
			total += item.getProduto().getPeso();
		return total * 0.5;
	}

}
