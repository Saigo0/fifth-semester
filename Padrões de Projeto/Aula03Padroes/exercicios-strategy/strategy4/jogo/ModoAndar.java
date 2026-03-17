package strategy4.jogo;

public class ModoAndar implements Modo {

    @Override
    public void mover(Mecha mecha) throws InterruptedException {
        Thread.sleep(1000); // demora mais para chegar ao destino
        System.out.println("Andando");
    }
}
