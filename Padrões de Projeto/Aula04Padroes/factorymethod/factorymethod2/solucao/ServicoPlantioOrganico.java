package factorymethod2.solucao;

import java.time.LocalDate;

public class ServicoPlantioOrganico extends ServicoPlantio{
    @Override
    protected void aplicarDataColheita(Plantio plantio, LocalDate dataPlantio) {

    }

    @Override
    protected void aplicarPesticidas(Plantio plantio, LocalDate dataPlantio) {

    }

    @Override
    protected Plantio criarPlantio(){
        return new PlantioOrganico();
    }
}
