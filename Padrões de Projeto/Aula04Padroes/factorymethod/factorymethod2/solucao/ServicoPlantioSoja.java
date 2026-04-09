package factorymethod2.solucao;

import java.time.LocalDate;

public class ServicoPlantioSoja extends ServicoPlantio {

    @Override
    protected void aplicarDataColheita(Plantio plantio, LocalDate dataPlantio) {
        plantio.setDataColheita(dataPlantio.plusDays(100));
    }

    @Override
    protected void aplicarPesticidas(Plantio plantio, LocalDate dataPlantio) {
        plantio.adicionarPesticida(dataPlantio.plusDays(20));
    }

    @Override
    protected Plantio criarPlantio() {
        return new PlantioSoja();
    }

}
