package composite4;

public class Aeroporto extends LinhaAerea {

    public Aeroporto(String nome){
        this.nome = nome;
    }

    public void imprimir()
    {
        System.out.println("Nome: " + this.getNome() + "\nPreço do voo: " + this.getPreco() + "\nTempo do voo: " + getTempoVoo());
    }

}
