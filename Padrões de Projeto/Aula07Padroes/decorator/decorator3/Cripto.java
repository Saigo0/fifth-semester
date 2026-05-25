package decorator3;

public class Cripto extends TextoDecorator {

    private Texto texto;

    public Cripto(Texto texto) {
        super(texto);
        this.texto = texto;
    }

    @Override
    public String getTexto(){
        String original = super.getTexto();
        char[] array =  original.toCharArray();
        StringBuilder tCripto = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                tCripto.append(' ');
            } else{
                tCripto.append((char) (array[i] + 1));
            }
        }
        return tCripto.toString();
    }

}
