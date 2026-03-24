package factorymethod1.pedido;

import factorymethod1.factory.CalculoFrete;
import factorymethod1.factory.CalculoTransportadora;

public class PedidoV2Transportadora extends PedidoV2 {

	@Override
	protected CalculoFrete criarCalculoFrete() {
		return new CalculoTransportadora();
	}

}
