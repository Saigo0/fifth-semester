package decorator4;

import decorator2.PedidoComponente;

public abstract class SanduicheDecorator implements Sanduiche{

    private Sanduiche sanduiche;

    public SanduicheDecorator(Sanduiche sanduiche) {
        this.sanduiche = sanduiche;
    }

    @Override
    public double getPreco(){
        return sanduiche.getPreco();
    }

    public String toString(){
        return sanduiche.toString();
    }

}
