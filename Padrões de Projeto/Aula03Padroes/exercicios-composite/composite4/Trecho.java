package composite4;

public class Trecho extends LinhaAerea {

    private LinhaAerea origem;
    private LinhaAerea destino;

    public Trecho(LinhaAerea origem, LinhaAerea destino, double preco, double tempoVoo) {
        this.preco = preco;
        this.tempo = tempoVoo;
        this.origem = origem;
        this.destino = destino;
    }

    public double getTempo() {
        double tempo = 0;
        tempo += origem.getTempo();
        tempo += destino.getTempo();
        return tempo;
    }

    public double getPreco() {
        double preco = 0;
        preco += origem.getPreco();
        preco += destino.getPreco();
        return preco;
    }

    public String getNome(){
        return origem.getNome() + "_" + destino.getNome();
    }

    public void imprimir() {
        System.out.println("\n\nTrecho " + this.getNome() + ":" + "\n\nPreço total: " + this.getPreco() + "\nTempo de voo total: " +  this.getTempo());
    }

}
