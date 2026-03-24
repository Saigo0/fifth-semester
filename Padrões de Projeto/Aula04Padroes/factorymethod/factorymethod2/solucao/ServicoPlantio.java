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

        if (tipoCultura.equals("MILHO")) {
            plantio.setDataColheita(dataPlantio.plusDays(120));

            // PODEM haver mais datas de aplicacao de pesticidas
            plantio.adicionarPesticida(dataPlantio.plusDays(30));
            plantio.adicionarPesticida(dataPlantio.plusDays(60));
            
        } else if (tipoCultura.equals("SOJA")) {
            plantio.setDataColheita(dataPlantio.plusDays(100));
            
            // SOMENTE pode haver uma data
            plantio.adicionarPesticida(dataPlantio.plusDays(20));

        } else if (tipoCultura.equals("ORGANICO")) {
            plantio.setDataColheita(dataPlantio.plusDays(90));
            
            // NAO DEVE ter nenhum data de aplicacao de pesticidas

        } else {
            throw new IllegalArgumentException("Cultura inválida");
        }


    }

    protected abstract void aplicarDataColheita(Plantio plantio, LocalDate dataPlantio);

    protected abstract void aplicarPesticidas(Plantio plantio, LocalDate dataPlantio);

    protected abstract Plantio criarPlantio();
}