package composite4;

public class Aeroporto extends LinhaAerea {

    public Aeroporto(String nome){
        this.nome = nome;
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
    public double getTempo() {
        return tempo;
    }

    public void imprimir()
    {
        System.out.println("Nome: " + this.getNome() + "\nPreço do voo: " + this.getPreco() + "\nTempo do voo: " + getTempo());
    }

}
