package factorymethod2.solucao;

import factorymethod2.problema.ServicoPlantio;

import java.time.LocalDate;

public class Sistema {

    public static void main(String[] args) {

        ServicoPlantio fazenda;

    	fazenda = new ServicoPlantioMilho();

        fazenda.prepararPlantio("MILHO", LocalDate.now());

        fazenda.prepararPlantio("SOJA", LocalDate.now().plusDays(7));
        
        fazenda.prepararPlantio("ORGANICO", LocalDate.now().plusDays(10));
        
        System.out.println(fazenda.getPlantios());
    }
}
