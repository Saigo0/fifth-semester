package composite4;

public abstract class LinhaAerea {

    private String nome;
    private double preco;
    private double tempoVoo;
    private double taxa;
    private double tempoParada;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getTempoVoo() {
        return tempoVoo;
    }
    public double getTaxa() {
        return taxa;
    }

    public double getTempoParada() {
        return tempoParada;
    }

    public abstract double calcPrecoTotal();

    public abstract double calcTempoTotal();

    protected abstract void imprimir();
}
