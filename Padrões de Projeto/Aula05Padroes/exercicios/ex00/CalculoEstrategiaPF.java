package ex00;

public class CalculoEstrategiaPF implements CalculoEstrategia {
    @Override
    public double calcularValor(Pedido pedido) {
        double valor = pedido.getValorBase();
        if(pedido.getFormaPagamento().equals("avista")){
            valor -= valor * 0.05;
        }

        valor += valor * 0.08;

        return valor;
    }
}
