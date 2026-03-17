package strategy4.jogo;

public class ModoCombate implements Modo{

    @Override
    public void mover(Mecha mecha) throws InterruptedException {
        Thread.sleep(2000); // demora ainda mais para chegar ao destino
        System.out.println("Combatendo");
    }
}
