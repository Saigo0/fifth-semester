package ex00;

public class CalculoEstrategiaPJ implements CalculoEstrategia{
    @Override
    public double calcularValor(Pedido pedido) {
        double valor = pedido.getValorBase();

        valor -= valor * 0.10;
        valor += valor * 0.12;

        return valor;
    }
}
