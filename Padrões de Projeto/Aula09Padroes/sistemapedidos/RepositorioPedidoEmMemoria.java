import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class RepositorioPedidoEmMemoria implements RepositorioPedido {

    private final Map<String, Pedido> armazenamento = new HashMap<>();

    @Override
    public void salvar(Pedido pedido) {
        armazenamento.put(pedido.getId(), pedido);
    }

    @Override
    public void atualizar(Pedido pedido) {
        if (!armazenamento.containsKey(pedido.getId())) {
            throw new IllegalArgumentException("Pedido não encontrado: " + pedido.getId());
        }
        armazenamento.put(pedido.getId(), pedido);
    }

    @Override
    public void deletar(String pedidoId) {
        armazenamento.remove(pedidoId);
    }

    @Override
    public Pedido buscarPorId(String pedidoId) {
        return armazenamento.get(pedidoId);
    }

    @Override
    public List<Pedido> buscarPorCliente(String clienteId) {
        return armazenamento.values().stream()
                .filter(p -> p.getClienteId().equals(clienteId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pedido> buscarPorStatus(Pedido.Status status) {
        return armazenamento.values().stream()
                .filter(p -> p.getStatus() == status)
                .collect(Collectors.toList());
    }

    @Override
    public List<Pedido> buscarTodos() {
        return new ArrayList<>(armazenamento.values());
    }

    @Override
    public List<Pedido> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return armazenamento.values().stream()
                .filter(p -> !p.getCriadoEm().isBefore(inicio) && !p.getCriadoEm().isAfter(fim))
                .collect(Collectors.toList());
    }

    @Override
    public double calcularReceitaTotal(LocalDateTime inicio, LocalDateTime fim) {
        return buscarPorPeriodo(inicio, fim).stream()
                .mapToDouble(Pedido::calcularTotal)
                .sum();
    }

    @Override
    public List<Produto> listarProdutosMaisVendidos(int limite) {
        throw new UnsupportedOperationException(
                "listarProdutosMaisVendidos não é suportado pelo repositório em memória");
    }

    @Override
    public String exportarParaCsv(List<Pedido> pedidos) {
        throw new UnsupportedOperationException(
                "exportarParaCsv não é suportado pelo repositório em memória");
    }

    @Override
    public byte[] exportarParaPdf(List<Pedido> pedidos) {
        throw new UnsupportedOperationException(
                "exportarParaPdf não é suportado pelo repositório em memória");
    }

    @Override
    public void sincronizarComErp(List<Pedido> pedidos) {
        throw new UnsupportedOperationException(
                "sincronizarComErp não é suportado pelo repositório em memória");
    }
}