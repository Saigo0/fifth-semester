import java.util.List;

/**
 * Monitor de estoque que verifica pedidos periodicamente.
 */

public class MonitorEstoque {

    private static final int ESTOQUE_MINIMO = 5;

    private final RepositorioPedido repositorio;
    private final EmailNotificador emailNotificador;
    private final Logger logger;

    public MonitorEstoque() {
    	repositorio = new RepositorioPedidoEmMemoria();
    	emailNotificador = new EmailNotificador();
    	logger = new Logger("MonitorEstoque");
	}
    
    public void verificarEstoquePosPedido() {
        logger.info("Iniciando verificação de estoque...");
        long inicio = System.currentTimeMillis();

        List<Pedido> pedidosConfirmados = repositorio.buscarPorStatus(Pedido.Status.CONFIRMADO);

        for (Pedido pedido : pedidosConfirmados) {
            pedido.getItens().forEach(item -> {
                Produto produto = item.getProduto();
                if (produto.getEstoque() < ESTOQUE_MINIMO) {
                    logger.info("Estoque baixo detectado: " + produto.getNome()
                            + " (restam " + produto.getEstoque() + " unidades)");
                    emailNotificador.alertarEstoque(produto);
                }
            });
        }

        long duracao = System.currentTimeMillis() - inicio;
        logger.info("Verificação concluída | duração: " + duracao + "ms");
    }

    public void gerarRelatorioEstoqueCritico() {
        logger.info("Gerando relatório de estoque crítico...");
        long inicio = System.currentTimeMillis();

        List<Pedido> todosPedidos = repositorio.buscarTodos();

        System.out.println("=== RELATÓRIO DE ESTOQUE CRÍTICO ===");
        todosPedidos.stream()
                .flatMap(p -> p.getItens().stream())
                .map(i -> i.getProduto())
                .filter(p -> p.getEstoque() < ESTOQUE_MINIMO)
                .distinct()
                .forEach(p -> System.out.println(
                        "CRÍTICO: " + p.getNome() + " | estoque: " + p.getEstoque()));

        long duracao = System.currentTimeMillis() - inicio;
        logger.info("Relatório gerado | duração: " + duracao + "ms");
    }
}