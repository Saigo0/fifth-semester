package abstractfactory3.controle.exportaramericadonorte;

import abstractfactory3.controle.abstractfactory.AbstractFreteFactory;
import abstractfactory3.controle.abstractfactory.Encomenda;

public class ExportarAmericaDoNorte extends AbstractFreteFactory {
    @Override
    public Encomenda prepararEncomendaExpresso() throws Exception {
        return new EncomendaExpressoExportarAmericaDoNorte();
    }

    @Override
    public Encomenda prepararEncomendaNormal() throws Exception {
        return new  EncomendaNormalExportarAmericaDoNorte();
    }
}
