package strategy4.jogo;

public class ModoVoo implements Modo{
    @Override
    public void mover(int x, int y) throws InterruptedException {
        Thread.sleep(100); // chega mais rapido ao destino
        System.out.println("Voando");
    }
}
