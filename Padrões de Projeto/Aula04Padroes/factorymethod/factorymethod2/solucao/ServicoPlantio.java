package factorymethod2.solucao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ServicoPlantio {

	private List<Plantio> plantios = new ArrayList<>();
	
	public List<Plantio> getPlantios() {
		return plantios;
	}
	
    public void prepararPlantio(String tipoCultura, LocalDate dataPlantio) {

        Plantio plantio = criarPlantio();

        plantio.setDataPlantio(dataPlantio);

        aplicarPesticidas(plantio, dataPlantio);
        
        aplicarDataColheita(plantio, dataPlantio);

        plantios.add(plantio);

    }

    protected abstract void aplicarDataColheita(Plantio plantio, LocalDate dataPlantio);

    protected abstract void aplicarPesticidas(Plantio plantio, LocalDate dataPlantio);

    protected abstract Plantio criarPlantio();
}