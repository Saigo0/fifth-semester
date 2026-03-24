package factorymethod2.solucao;

import java.time.LocalDate;

public class PlantioSoja extends Plantio{

    private boolean aplicou = false;

    public PlantioSoja() {
        super("Soja");
    }

    @Override
    public void adicionarPesticida(LocalDate data){
        if(aplicou)
            throw new RuntimeException("Somente pode um vez");
        super.adicionarPesticida(data);
        aplicou = true;
    }
}
