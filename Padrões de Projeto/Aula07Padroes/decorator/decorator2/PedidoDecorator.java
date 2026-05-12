package decorator2;

public abstract class PedidoDecorator {

    private PedidoComponente pedidoComponente;
    private FreteStrategy freteStrategy;

    PedidoDecorator(PedidoComponente pedidoComponente){
        this.pedidoComponente = pedidoComponente;
    }

    public void concluir(){
        pedidoComponente.concluir();
    }

    public double getTotal(){
        return pedidoComponente.getTotal();
    }
}
