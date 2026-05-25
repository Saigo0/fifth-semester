package decorator3;

import decorator2.PedidoComponente;

import java.util.Arrays;

public class Inversor extends TextoDecorator {

    private Texto texto;

    public Inversor(Texto texto) {
        super(texto);
        this.texto = texto;
    }

    @Override
    public String getTexto(){

        String original = super.getTexto();
        char[] array =  original.toCharArray();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < array.length; i++) {
            buffer.append(array[array.length -1 - i]);
        }

        return buffer.toString();

    }

}
