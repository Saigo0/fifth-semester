package ex02.refatoracao;

public class EstrategiaFactory {
    public CalculoFrete criarEstrategia(String enderecoEntrega){
        ExtracaoCEP ec = new ExtracaoCEP();
        if(ec.extrairCep(enderecoEntrega).equals());
    }
}
