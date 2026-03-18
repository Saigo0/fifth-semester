package strategy4.jogo;

public class ModoAndar implements Modo {

    @Override
    public void mover(int x, int y) throws InterruptedException {
        Thread.sleep(1000); // demora mais para chegar ao destino
        System.out.println("Andando");
    }
}
