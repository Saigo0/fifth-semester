package factorymethod1.pedido;

import factorymethod1.factory.CalculoFrete;
import factorymethod1.factory.CalculoSedex;

public class PedidoV2Sedex extends PedidoV2 {

	@Override
	protected CalculoFrete criarCalculoFrete() {
		return new CalculoSedex();
	}

}
