package composite4;

public abstract class LinhaAerea {

    protected String nome;
    protected double preco;
    protected double tempo;

    public abstract String getNome();

    public abstract double getPreco();

    public abstract double getTempo();

    protected abstract void imprimir();
}
