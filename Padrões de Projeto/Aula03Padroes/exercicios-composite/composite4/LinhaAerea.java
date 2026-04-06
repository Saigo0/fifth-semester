package composite4;

public abstract class LinhaAerea {

    protected String nome;
    protected double preco;
    protected double tempoVoo;

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public double getTempoVoo(){
        return tempoVoo;
    }

    protected abstract void imprimir();
}
