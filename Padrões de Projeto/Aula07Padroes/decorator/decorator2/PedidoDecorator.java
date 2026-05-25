package decorator2;

public abstract class PedidoDecorator implements PedidoComponente{

    private PedidoComponente pedidoComponente;

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
