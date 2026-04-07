package composite4;

public abstract class LinhaAerea {

    private String nome;
    private double preco;
    private double tempo;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco(){
        return preco;
    };

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTempo(){
        return tempo;
    };

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public abstract void imprimir();
}
