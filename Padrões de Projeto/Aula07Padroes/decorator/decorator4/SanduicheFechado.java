package decorator4;

public class SanduicheFechado implements Sanduiche {

    private double preco;

    @Override
    public double getPreco() {
        return 1.0;
    }

    public String toString(){
        return "(Tudo dentro da caixa)";
    }
}
