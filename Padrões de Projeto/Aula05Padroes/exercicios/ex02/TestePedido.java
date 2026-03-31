package ex02;

import java.util.Scanner;

public class TestePedido {
    
    public static void main(String[] args) {
       
        System.out.println("=".repeat(80));
        System.out.println("TESTE DO SISTEMA DE PEDIDOS");
        System.out.println("=".repeat(80));
        
        testarCenariosPreDefinidos();
        
        System.out.println("Encerrando sistema...");
    }
    

    private static void testarCenariosPreDefinidos() {
        System.out.println("\n=== TESTANDO CENARIOS PRE-DEFINIDOS ===\n");
        
        // Cenario 1: Cliente PF, compra pequena no Sudeste
        System.out.println("CENARIO 1: Cliente PF - Compra pequena no Sudeste");
        System.out.println("-".repeat(60));
        Pedido pedido1 = new Pedido(1001, "João Silva", "PF", "Rua das Flores, 123 - CEP:01234", "PIX");
        pedido1.adicionarItem(new ItemPedido("Camiseta", 2, 49.90, "ROUPA"));
        pedido1.adicionarItem(new ItemPedido("Calca Jeans", 1, 129.90, "ROUPA"));
        pedido1.calcularTotal();
        pedido1.gerarNotaFiscal();
        pedido1.enviarEmailConfirmacao();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Cenario 2: Cliente PF, compra grande no Sudeste (frete gratis)
        System.out.println("CENARIO 2: Cliente PF - Compra grande no Sudeste (frete grátis)");
        System.out.println("-".repeat(60));
        Pedido pedido2 = new Pedido(1002, "Maria Santos", "PF", "Av. Paulista, 1000 - CEP:01310", "CARTAO");
        pedido2.adicionarItem(new ItemPedido("Notebook", 1, 3500.00, "ELETRONICO"));
        pedido2.adicionarItem(new ItemPedido("Mouse", 2, 150.00, "ELETRONICO"));
        pedido2.calcularTotal();
        pedido2.gerarNotaFiscal();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Cenario 3: Cliente PJ, compra no Norte (frete mais caro com desconto PJ)
        System.out.println("CENARIO 3: Cliente PJ - Compra no Norte");
        System.out.println("-".repeat(60));
        Pedido pedido3 = new Pedido(1003, "Empresa XYZ Ltda", "PJ", "Av. Amazonas, 500 - CEP:05000", "BOLETO");
        pedido3.adicionarItem(new ItemPedido("Impressora", 3, 850.00, "ELETRONICO"));
        pedido3.adicionarItem(new ItemPedido("Papel A4", 10, 25.00, "OUTRO"));
        pedido3.calcularTotal();
        pedido3.gerarNotaFiscal();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Cenario 4: Cliente PF, produtos eletrônicos (imposto adicional)
        System.out.println("CENARIO 4: Cliente PF - Produtos eletrônicos");
        System.out.println("-".repeat(60));
        Pedido pedido4 = new Pedido(1004, "Carlos Andrade", "PF", "Rua dos Eletrônicos, 50 - CEP:02000", "CARTAO");
        pedido4.adicionarItem(new ItemPedido("Smartphone", 2, 2500.00, "ELETRONICO"));
        pedido4.adicionarItem(new ItemPedido("Fone Bluetooth", 3, 200.00, "ELETRONICO"));
        pedido4.calcularTotal();
        pedido4.gerarNotaFiscal();
        
        System.out.println("\n Todos os cenários testados!");
        System.out.print("\nPressione ENTER para continuar...");
        new Scanner(System.in).nextLine();
    }
    

}