package ex04.strategy;

import ex04.pedido.PedidoV2;

public interface CalculoFrete {

	double calcular(PedidoV2 pedido) throws Exception;
	
}
