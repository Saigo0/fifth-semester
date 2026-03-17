package strategy3.loja;

public class CalculoDescontoAcimaTrezentos implements CalculoDesconto {

    @Override
    public double calcularDesconto(Venda venda) {
        if(venda.getValorTotalBruto() > 300.0){
            return venda.getValorTotalBruto() - 20.0;
        } else {
            return venda.getValorTotalBruto();
        }

    }
}
