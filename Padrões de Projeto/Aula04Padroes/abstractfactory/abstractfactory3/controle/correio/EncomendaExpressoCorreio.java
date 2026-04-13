package abstractfactory3.controle.correio;

import abstractfactory3.controle.abstractfactory.Destino;
import abstractfactory3.controle.abstractfactory.EncomendaExpresso;

public class EncomendaExpressoCorreio extends EncomendaExpresso {
    public double getPreco() throws Exception {
        Destino destino = this.getDestino();

        if(!(this.getPeso() > 0)){
            throw  new IllegalArgumentException("Peso menor ou igual a 0");
        }

        if(destino == null){
            throw new Exception("Destino não pode ser nulo");
        }

        return switch (destino) {
            case NORTE, NORDESTE -> this.getPeso() * 0.05;
            case CENTROOESTE -> this.getPeso() * 0.075;
            case SUDESTE, SUL -> this.getPeso() * 0.025;
            default -> throw new Exception("Destino não suportado");
        };
    }
}
