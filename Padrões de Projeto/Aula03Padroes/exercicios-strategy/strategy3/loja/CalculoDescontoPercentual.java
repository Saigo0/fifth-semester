package strategy3.loja;

public class CalculoDescontoPercentual implements CalculoDesconto {

    @Override
    public double calcularDesconto(Venda venda) {
        return venda.getValorTotalBruto() - venda.getValorTotalBruto() * 0.15;
    }
}
