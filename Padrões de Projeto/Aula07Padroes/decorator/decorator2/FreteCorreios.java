package decorator2;

public class FreteCorreios extends PedidoDecorator {

    FreteCorreios(PedidoComponente pedidoComponente) {
        super(pedidoComponente);
    }

    @Override
    public void concluir(){
        super.concluir();
        System.out.println("Frete Correios:\n" + "Preço total: " + this.getTotal());
    }

    @Override
    public double getTotal(){
        return super.getTotal() + 40;
    }

}
