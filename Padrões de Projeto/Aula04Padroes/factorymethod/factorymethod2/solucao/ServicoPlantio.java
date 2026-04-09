package factorymethod2.solucao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class ServicoPlantio {

	private List<Plantio> plantios = new ArrayList<>();
	
	public List<Plantio> getPlantios() {
		return plantios;
	}

    public void addPlantio(Plantio plantio) {
        this.plantios.add(plantio);
    }
	
    public void prepararPlantio(LocalDate dataPlantio) {

        Plantio plantio = criarPlantio();

        plantio.setDataPlantio(dataPlantio);

        aplicarPesticidas(plantio, dataPlantio);

        aplicarDataColheita(plantio, dataPlantio);

        addPlantio(plantio);
    }

    protected abstract void aplicarDataColheita(Plantio plantio, LocalDate dataPlantio);

    protected abstract void aplicarPesticidas(Plantio plantio, LocalDate dataPlantio);

    protected abstract Plantio criarPlantio();
}