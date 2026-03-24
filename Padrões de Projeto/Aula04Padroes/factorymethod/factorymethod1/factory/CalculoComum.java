package factorymethod1.factory;

import factorymethod1.pedido.ItemPedido;
import factorymethod1.pedido.PedidoV2;

public class CalculoComum implements CalculoFrete {

	@Override
	public double calcular(PedidoV2 pedido) throws Exception {
		double total = 0;
		for (ItemPedido item:pedido.getItensPedido())
			total += item.getProduto().getPeso();
		return total * 0.5;
	}

}
