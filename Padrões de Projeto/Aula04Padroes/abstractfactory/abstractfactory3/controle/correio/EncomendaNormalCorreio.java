package abstractfactory3.controle.correio;

import abstractfactory3.controle.abstractfactory.Destino;
import abstractfactory3.controle.abstractfactory.EncomendaNormal;

public class EncomendaNormalCorreio extends EncomendaNormal {
    public double getPreco() throws Exception {
        Destino destino = this.getDestino();

        if(!(this.getVolume() > 0)){
            throw  new IllegalArgumentException("Volume menor ou igual a 0");
        }

        if(destino == null){
            throw new Exception("Destino não pode ser nulo");
        }

        return switch (destino) {
            case NORTE -> this.getVolume() * 0.03;
            case CENTROOESTE -> this.getVolume() * 0.04;
            case NORDESTE -> this.getVolume() * 0.02;
            case SUDESTE, SUL -> this.getVolume() * 0.01;
            case AMERICALATINA ->  this.getVolume() * 0.07;
            case AMERICADONORTE ->  this.getVolume() * 0.1;
            case EUROPA ->  this.getVolume() * 0.15;
            case AFRICA ->  this.getVolume() * 0.25;
            case ASIA -> this.getVolume() * 0.17;
            case OCEANIA ->  this.getVolume() * 0.3;
            default -> throw new Exception("Destino não suportado");
        };
    }
}
