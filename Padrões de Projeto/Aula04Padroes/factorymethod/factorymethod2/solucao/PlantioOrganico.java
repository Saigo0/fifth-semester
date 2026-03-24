package factorymethod2.solucao;

import java.time.LocalDate;

public class PlantioOrganico extends Plantio{
    public PlantioOrganico() {
        super("Organico");
    }

    @Override
    public void adicionarPesticida(LocalDate data){
        throw new RuntimeException("Não é possível adicionar pesticida");
    }
}
