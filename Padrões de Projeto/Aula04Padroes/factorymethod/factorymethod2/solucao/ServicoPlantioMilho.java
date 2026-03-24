package factorymethod2.solucao;


import java.time.LocalDate;

public class ServicoPlantioMilho extends ServicoPlantio{
    @Override
    protected void aplicarDataColheita(Plantio plantio, LocalDate dataPlantio) {
        plantio.setDataColheita(dataPlantio.plusDays(120));
    }

    @Override
    protected void aplicarPesticidas(Plantio plantio, LocalDate dataPlantio) {

    }

    @Override
    protected Plantio criarPlantio(){
        return new PlantioMilho();
    }
}
