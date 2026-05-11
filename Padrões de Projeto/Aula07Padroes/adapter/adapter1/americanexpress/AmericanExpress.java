package adapter1.americanexpress;

public class AmericanExpress {

	private String nome;
	private String numero;
	private double valor;
	private int anoVencimento;
	private int mesVencimento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getAnoVencimento() {
		return anoVencimento;
	}
	public void setAnoVencimento(int anoVencimento) {
		this.anoVencimento = anoVencimento;
	}
	public int getMesVencimento() {
		return mesVencimento;
	}
	public void setMesVencimento(int mesVencimento) {
		this.mesVencimento = mesVencimento;
	}
	
	public void pagar() throws Exception {
		if (valor < 100) {
			// aprovado
		} else
			throw new Exception("Ultrapassou o limite.");
	}
	
	
}
