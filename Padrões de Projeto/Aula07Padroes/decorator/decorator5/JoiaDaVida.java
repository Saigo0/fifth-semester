package decorator5;

public class JoiaDaVida extends OrcDecorator{
    public JoiaDaVida(Orc orc) {
        super(orc);
    }

    @Override
    public void setSaude(int saude){
        super.setSaude((int) (super.getSaude() * 1.2));
    }
}
