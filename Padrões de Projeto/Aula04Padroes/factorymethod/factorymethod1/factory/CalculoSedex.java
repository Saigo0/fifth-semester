package factorymethod1.factory;

import factorymethod1.pedido.ItemPedido;
import factorymethod1.pedido.PedidoV2;

public class CalculoSedex implements CalculoFrete {

	@Override
	public double calcular(PedidoV2 pedido) {
		double total = 0;
		for (ItemPedido item:pedido.getItensPedido())
			total += item.getProduto().getPeso();
		return total * 3;
	};

}
