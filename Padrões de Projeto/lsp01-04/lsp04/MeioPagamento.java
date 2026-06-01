package lsp04;

public class MeioPagamento {

    protected double saldoDisponivel;
    
    public void pagar(double valor) {
         if (valor > saldoDisponivel) {
            throw new RuntimeException("Saldo insuficiente");
        }
        
        saldoDisponivel -= valor;
    }
    
    public double getSaldo() {
        return saldoDisponivel;
    }
}
