package adapter1.sistemavendas;

public interface Cartao {

	void pagar(String nome, String numero, double valor, String validade) throws Exception;
	
}
