package strategy1.strategy;

import org.junit.Test;
import strategy1.pedido.PedidoV2;

public class TestarFrete {

    @Test
    public void calcularFrete(){
        CalculoFrete calculoFrete = new CalculoSedex();
        PedidoV2 p = new PedidoV2(calculoFrete);

       //assertEquals
    }

}
