package decorator5;

import java.util.Random;

public class Escudo extends OrcDecorator{
    public Escudo(Orc orc){
        super(orc);
    }

    @Override
    public void defender(int ataque){
        setSaude(getSaude() - (ataque - 7));
    }

}
