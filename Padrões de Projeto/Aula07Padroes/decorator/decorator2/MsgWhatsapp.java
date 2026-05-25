package decorator2;

public class MsgWhatsapp extends PedidoDecorator{
    private String numeroWhats;

    MsgWhatsapp(PedidoComponente pedidoComponente, String numeroWhats) {
        super(pedidoComponente);
        this.numeroWhats = numeroWhats;
    }

    @Override
    public void concluir(){
        super.concluir();
        System.out.println("Enviando mensagem para " + numeroWhats + ". O valor do pedido ficou em " + getTotal());
    }
}
