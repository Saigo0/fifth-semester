import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    public enum Status { PENDENTE, CONFIRMADO, ENVIADO, ENTREGUE, CANCELADO }

    private String id;
    private String clienteId;
    private List<ItemPedido> itens;
    private Status status;
    private LocalDateTime criadoEm;
    private String enderecoEntrega;

    public Pedido(String id, String clienteId, List<ItemPedido> itens, String enderecoEntrega) {
        this.id = id;
        this.clienteId = clienteId;
        this.itens = itens;
        this.status = Status.PENDENTE;
        this.criadoEm = LocalDateTime.now();
        this.enderecoEntrega = enderecoEntrega;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido ip: itens)
        	total += ip.getProduto().getPreco() * ip.getQuantidade();
        return total;
    }

    public String getId() { return id; }
    public String getClienteId() { return clienteId; }
    public List<ItemPedido> getItens() { return itens; }
    public Status getStatus() { return status; }
    public LocalDateTime getCriadoEm() { return criadoEm; }
    public String getEnderecoEntrega() { return enderecoEntrega; }

    public void setStatus(Status status) { this.status = status; }
}
