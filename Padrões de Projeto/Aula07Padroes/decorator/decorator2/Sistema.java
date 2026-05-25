package decorator2;

public class Sistema {

    public static void main(String [] args){
        PedidoComponente p1 = new Pedido(200);

        PedidoComponente p1FreteC = new FreteCorreios(p1);
        p1FreteC.concluir();

        PedidoComponente p1FreteCMsgWhats = new MsgWhatsapp(p1FreteC, "61983047228");
        p1FreteCMsgWhats.concluir();
    }


}
