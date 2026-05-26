import java.time.LocalDateTime;
import java.util.List;

public interface RepositorioPedido {

    // --- operacoes de escrita ---
    void salvar(Pedido pedido);
    void atualizar(Pedido pedido);
    void deletar(String pedidoId);

    // --- operacoes de leitura ---
    Pedido buscarPorId(String pedidoId);
    List<Pedido> buscarPorCliente(String clienteId);
    List<Pedido> buscarPorStatus(Pedido.Status status);
    List<Pedido> buscarTodos();

    // --- relatorios ---
    List<Pedido> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim);
    double calcularReceitaTotal(LocalDateTime inicio, LocalDateTime fim);
    List<Produto> listarProdutosMaisVendidos(int limite);

    // --- exportacao ---
    String exportarParaCsv(List<Pedido> pedidos);
    byte[] exportarParaPdf(List<Pedido> pedidos);
    void sincronizarComErp(List<Pedido> pedidos);
}