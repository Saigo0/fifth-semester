package composite4;

public class TrechoIndividual extends LinhaAerea {
    private String nome;
    private double preco;
    private int tempo;

    public TrechoIndividual(String nome, double preco, int tempo) {
        this.nome = nome;
        this.preco = preco;
        this.tempo = tempo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public int getTempo() {
        return tempo;
    }
}
