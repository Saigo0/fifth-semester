package ex01;

import java.util.Arrays;
import java.util.List;

public class TesteProcessadorRelatorio {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("TESTE DO PROCESSADOR DE RELATORIO");
        System.out.println("=".repeat(70));
        
        // Criando dados de exemplo
        List<ItemVenda> itens = criarItensVenda();
        
        // Exibindo os itens que serao processados
        System.out.println("\nITENS DA VENDA:");
        System.out.println("-".repeat(70));
        exibirItensVenda(itens);

        ProcessadorRelatorio processador = new ProcessadorRelatorio();
        
        System.out.println("\nINICIANDO PROCESSAMENTO DO RELATÓRIO...");
        System.out.println("-".repeat(70));
        
        // Processando o relatório
        processador.processarEEnviarRelatorio(
            "Relatorio de Vendas Mensal",  // titulo
            "30/03/2026",                  // data
            itens,                         // lista de itens
            "financeiro@empresa.com"       // destinatário
        );
        
        System.out.println("\n" + "-".repeat(70));
        System.out.println("PROCESSAMENTO CONCLUIDO!");
        
    }
    
    /**
     * Cria uma lista de itens de venda para teste
     */
    private static List<ItemVenda> criarItensVenda() {
        return Arrays.asList(
            new ItemVenda("Notebook Dell Inspiron", 2, 2800.00),
            new ItemVenda("Mouse Sem Fio Logitech", 3, 120.00),
            new ItemVenda("Teclado Mecanico RGB", 1, 380.00),
            new ItemVenda("Monitor 24 Polegadas", 2, 950.00),
            new ItemVenda("Headset Gamer", 1, 250.00)
        );
    }
    
    /**
     * Exibe os itens de venda formatados
     */
    private static void exibirItensVenda(List<ItemVenda> itens) {
        System.out.printf("%-30s %8s %12s %12s%n", 
                         "Produto", "Qtd", "Preco Unit.", "Subtotal");
        System.out.println("-".repeat(70));
        
        double total = 0;
        for (ItemVenda item : itens) {
            double subtotal = item.getQuantidade() * item.getPrecoUnitario();
            total += subtotal;
            
            System.out.printf("%-30s %8d R$ %9.2f R$ %9.2f%n",
                             item.getNome(),
                             item.getQuantidade(),
                             item.getPrecoUnitario(),
                             subtotal);
        }
        
        System.out.println("-".repeat(70));
        System.out.printf("%-52s R$ %9.2f%n", "TOTAL BRUTO:", total);
        
        if (total > 1000) {
            double desconto = total * 0.10;
            double totalComDesconto = total - desconto;
            System.out.printf("%-52s R$ %9.2f%n", "DESCONTO (10%):", -desconto);
            System.out.printf("%-52s R$ %9.2f%n", "TOTAL LIQUIDO:", totalComDesconto);
        }
    }
    

}