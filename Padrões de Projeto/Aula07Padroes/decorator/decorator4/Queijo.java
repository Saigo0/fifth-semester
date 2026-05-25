package decorator4;

public class Queijo extends SanduicheDecorator{

    public Queijo(Sanduiche sanduiche) {
        super(sanduiche);
    }

    @Override
    public double getPreco(){
        return super.getPreco() + 0.75;
    }

    @Override
    public String toString(){
        return "Queijo " + super.toString();
    }
}
