package factorymethod2.solucao;


import java.time.LocalDate;

public class Sistema {

    public static void main(String[] args) {

        ServicoPlantio fazenda;

        fazenda = new ServicoPlantioMilho();
        fazenda.prepararPlantio(LocalDate.now());

        fazenda = new ServicoPlantioSoja();
        fazenda.prepararPlantio(LocalDate.now().plusDays(7));

        fazenda = new ServicoPlantioOrganico();
        fazenda.prepararPlantio(LocalDate.now().plusDays(10));

    }
}
