package composite4;

public class Trecho extends LinhaAerea {

    private LinhaAerea origem;
    private LinhaAerea destino;

    public Trecho(LinhaAerea origem, LinhaAerea destino, double preco, double tempoVoo) {
        this.setPreco(preco + super.getPreco());
        this.setTempo(tempoVoo + super.getTempo());
        this.origem = origem;
        this.destino = destino;
    }

    public double getTempo() {
        double tempo = super.getTempo();
        tempo += destino.getTempo();
        tempo += destino.getTempo();
        return tempo;
    }

    public double getPreco() {
        double preco = super.getPreco();
        preco += origem.getPreco();
        preco += destino.getPreco();
        return preco;
    }

    public String getNome(){
        return origem.getNome() + "_" + destino.getNome();
    }

    public void imprimir() {
        System.out.println("\n\nTrecho " + this.getNome() + ":" + "\n\nAeroporto de origem: " + origem.getNome() + "\n\nAeroporto de destino" + destino.getNome() + "\n\nTempo de parada: " + destino.getTempo() + "\n\nTaxa cobrada: " + destino.getPreco() + "\n\nPreço total: " + this.getPreco() + "\nTempo de voo total: " +  this.getTempo() + "\n\n----------------------------------------------------");
    }

}
