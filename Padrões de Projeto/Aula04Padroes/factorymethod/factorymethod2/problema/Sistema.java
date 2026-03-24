package factorymethod2.problema;

import java.time.LocalDate;

public class Sistema {

    public static void main(String[] args) {

    	ServicoPlantio fazenda = new ServicoPlantio();

        fazenda.prepararPlantio("MILHO", LocalDate.now());

        fazenda.prepararPlantio("SOJA", LocalDate.now().plusDays(7));
        
        fazenda.prepararPlantio("ORGANICO", LocalDate.now().plusDays(10));
        
        System.out.println(fazenda.getPlantios());
    }
}
