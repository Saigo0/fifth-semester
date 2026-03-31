package composite4;

public class Aeroporto extends LinhaAerea {
    private boolean destino;
    private boolean origem;

    public boolean isDestino() {
        return destino;
    }

    public boolean isOrigem() {
        return origem;
    }


    public double calcTempoTotal() {
        double tempoTotal = 0;
        tempoTotal += this.getTempoParada();
        tempoTotal += this.getTempoVoo();
        return tempoTotal;
    }

    public double calcPrecoTotal(){
        double precoTotal = 0;
        precoTotal += this.getPreco();
        precoTotal += this.getTaxa();
        return precoTotal;
    }

    public void imprimir()
    {
        System.out.println("Nome: " + this.getNome() + "\nPreço do voo: " + this.getPreco() + "\nTaxa do voo: " +
                this.getTaxa() + "\nTempo do voo: " + calcTempoTotal());
    }

}
