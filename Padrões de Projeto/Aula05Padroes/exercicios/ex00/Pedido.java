package ex00;

public class Pedido {

    private double valorBase;
    private String tipoCliente; // "PF" ou "PJ"
    private String formaPagamento; // "avista" ou "parcelado"

    public double calcularValorFinal() {
        double valor = valorBase;

        CalculoEstrategia ce = EstrategiaFactory.criarEstrategia(tipoCliente);
        ce.calcularValor(this);

        return valor;
    }

    public double getValorBase() {
        return valorBase;
    }

    public String getFormaPagamento(){
        return formaPagamento;
    }
}
