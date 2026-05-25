package decorator2;

public class FreteTransportadora extends PedidoDecorator {
    FreteTransportadora(PedidoComponente pedidoComponente) {
        super(pedidoComponente);
    }

    @Override
    public void concluir(){
        super.concluir();
        System.out.println("Frete Transportadora:\n" + "Preço total: " + this.getTotal());
    }

    @Override
    public double getTotal(){
        return super.getTotal() + 30;
    }
}
