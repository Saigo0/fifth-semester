package abstractfactory3.controle.exportaramericadonorte;

import abstractfactory3.controle.abstractfactory.Destino;
import abstractfactory3.controle.abstractfactory.EncomendaExpresso;

public class EncomendaExpressoExportarAmericaDoNorte extends EncomendaExpresso {
    public EncomendaExpressoExportarAmericaDoNorte(){
        this.setDestino(Destino.AMERICADONORTE);
    }

    public double calcFatorModificacao(){
        if (this.getVolume() <= 27000){
            return 0.3;
        } else  if (this.getVolume() >= 27001 && this.getVolume() <= 21600){
            return 0.7;
        } else {
            return 1;
        }

    }

    public double getPreco(){
        if(!(this.getVolume() > 0) && !(this.getPeso() > 0)){
            throw  new IllegalArgumentException("Volume ou peso menor ou igual a 0");
        }

        return this.getVolume() * 0.009 +  this.getPeso() * calcFatorModificacao() * 0.005;
    }
}
