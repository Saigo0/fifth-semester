package factorymethod1.factory;

import factorymethod1.pedido.PedidoV2;

public interface CalculoFrete {

	double calcular(PedidoV2 pedido) throws Exception;
	
}
