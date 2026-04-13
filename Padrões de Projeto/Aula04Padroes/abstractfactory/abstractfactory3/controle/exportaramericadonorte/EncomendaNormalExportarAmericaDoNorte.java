package abstractfactory3.controle.exportaramericadonorte;

import abstractfactory3.controle.abstractfactory.EncomendaNormal;

public class EncomendaNormalExportarAmericaDoNorte extends EncomendaNormal {
    public double getPreco(){
        throw new UnsupportedOperationException("Modo de frete não suportado.");
    }

}
