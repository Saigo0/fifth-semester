package lsp04;

import javax.naming.LimitExceededException;

public class CartaoCredito extends MeioPagamento {
	
	private double limiteMaximoParcela = 500.0;
	private double limiteMinimoParcela = 10.0;
	private double limiteCartao = 1.5;
    
    @Override
    public void pagar(double valor) {
    	// Overlay Restrictive: testes nao previstos pela super classe
    	
        if (valor > limiteMaximoParcela) throws LimitExceededException {
            throw new LimitExceededException(
                "Valor da parcela excede limite de R$" + limiteMaximoParcela
            );
        }
        
        if (valor < limiteMinimoParcela) {
            throw new RuntimeException(
                "Valor m\u00EDnimo para cart\u00E3o de cr\u00E9dito \u00E9 R$"+ limiteMinimoParcela
            );
        }
        
        // (saldo + limite do cartao)
        if (valor > saldoDisponivel * limiteCartao) {
            throw new RuntimeException(
                "Valor excede limite total do cart\u00E3o"
            );
        }
        
        // Chama o metodo da superclase (que tem suas proprias validacoes)
        super.pagar(valor);
    }
}
