package factorymethod2.problema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicoPlantio {

	private List<Plantio> plantios = new ArrayList<>();
	
	public List<Plantio> getPlantios() {
		return plantios;
	}
	
    public void prepararPlantio(String tipoCultura, LocalDate dataPlantio) {

        Plantio plantio = new Plantio(tipoCultura);
        plantio.setDataPlantio(dataPlantio);

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

        plantios.add(plantio);
    }
}