package decorator5;

import java.util.Random;

public class Machado extends OrcDecorator{

    private static Random sorteio = new Random();

    public Machado(Orc orc) {
        super(orc);
    }

    public int atacar(){
        return super.atacar() + sorteio.nextInt(1, 5);
    }

}
