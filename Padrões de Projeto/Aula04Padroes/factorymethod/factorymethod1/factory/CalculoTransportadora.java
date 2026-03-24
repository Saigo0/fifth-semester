package factorymethod1.factory;

import factorymethod1.pedido.ItemPedido;
import factorymethod1.pedido.PedidoV2;

public class CalculoTransportadora implements CalculoFrete {

	@Override
	public double calcular(PedidoV2 pedido) {
		double totalDim = 0;
		double totalPeso = 0;
		for (ItemPedido item:pedido.getItensPedido()) {
			totalDim += item.getProduto().getDimensoes();
			totalPeso += item.getProduto().getPeso();
		}
		return (totalDim * 0.3) + (totalPeso * 1.2);
	}

}
