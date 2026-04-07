package composite4;

public class Aeroporto extends LinhaAerea {

    private double tempoParada;
    private double taxa;

    public Aeroporto(String nome, double tempoParada, double taxa){
        this.setNome(nome);
        this.tempoParada = tempoParada;
        this.taxa = taxa;
    }

    public double getTempo() {
        return tempoParada;
    }

    public double getPreco() {
        return taxa;
    }

    public void imprimir()
    {
        System.out.println("\n\nNome do aeroporto: " + this.getNome() + "\nTaxa: " + this.getPreco() + "\nTempo de parada: " + getTempo());
    }

}
