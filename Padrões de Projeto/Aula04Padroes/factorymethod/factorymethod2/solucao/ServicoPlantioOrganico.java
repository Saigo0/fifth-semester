package factorymethod2.solucao;

import java.time.LocalDate;

public class ServicoPlantioOrganico extends ServicoPlantio{
    @Override
    protected void aplicarDataColheita(Plantio plantio, LocalDate dataPlantio) {
        plantio.setDataPlantio(dataPlantio.plusDays(90));
    }

    @Override
    protected void aplicarPesticidas(Plantio plantio, LocalDate dataPlantio) {
        throw new RuntimeException("Não é possível aplicar pesticidas a plantios orgânicos");
    }

    @Override
    protected Plantio criarPlantio(){
        return new PlantioOrganico();
    }
}
