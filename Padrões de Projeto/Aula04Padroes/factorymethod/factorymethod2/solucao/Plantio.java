package factorymethod2.solucao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Plantio {

    private LocalDate dataPlantio;
    private LocalDate dataColheita;
    private List<LocalDate> datasPesticida = new ArrayList<>();
	private String cultura;

    public Plantio(String cultura) {
    	this.cultura = cultura;
    }
    
    public void setDataPlantio(LocalDate dataPlantio) {
        this.dataPlantio = dataPlantio;
    }

    public void setDataColheita(LocalDate dataColheita) {
        this.dataColheita = dataColheita;
    }

    public void adicionarPesticida(LocalDate data) {
        this.datasPesticida.add(data);
    }

    @Override
    public String toString() {
        return "Plantio "+ cultura +"{" +
                "plantio=" + dataPlantio +
                ", colheita=" + dataColheita +
                ", pesticidas=" + datasPesticida +

                '}';
    }
}
