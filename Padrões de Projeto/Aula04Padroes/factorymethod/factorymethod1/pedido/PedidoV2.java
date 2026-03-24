package factorymethod1.pedido;

import java.util.ArrayList;
import java.util.List;

import factorymethod1.factory.CalculoFrete;

public abstract class PedidoV2 {

	protected abstract CalculoFrete criarCalculoFrete();

	public double calcularFrete() throws Exception {
		CalculoFrete frete = criarCalculoFrete();

		return frete.calcular(this);
	}

	private List<ItemPedido> itensPedido = new ArrayList<>();

	public void addItemPedido(ItemPedido itemPedido) {
		itensPedido.add(itemPedido);
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

}
