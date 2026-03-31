package ex02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    // Atributos do pedido
    private int id;
    private String cliente;
    private String tipoCliente; // "PF" ou "PJ"
    private String enderecoEntrega;
    private String metodoPagamento; // "PIX", "CARTAO", "BOLETO"
    private List<ItemPedido> itens;
    private double valorTotal;
    
    public Pedido(int id, String cliente, String tipoCliente, String enderecoEntrega, String metodoPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.tipoCliente = tipoCliente;
        this.enderecoEntrega = enderecoEntrega;
        this.metodoPagamento = metodoPagamento;
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }
    
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        calcularTotal(); // Recalcula total sempre que item eh adicionado
    }
    
    public void removerItem(ItemPedido item) {
        itens.remove(item);
        calcularTotal();
    }
    
    public double calcularFrete() {
        double frete = 0;
        
        String cep = extrairCep(enderecoEntrega);
        
        if (cep.startsWith("01") || cep.startsWith("02")) {
            // Sudeste
            if (valorTotal > 500) {
                frete = 0; // Frete gratis para compras acima de R$500 no Sudeste
            } else {
                frete = 15.90;
            }
        } else if (cep.startsWith("03") || cep.startsWith("04")) {
            // Sul
            if (valorTotal > 300) {
                frete = 10.00;
            } else {
                frete = 25.90;
            }
        } else if (cep.startsWith("05") || cep.startsWith("06")) {
            // Norte/Nordeste
            frete = 45.90; // Frete fixo mais caro
        } else {
            frete = 30.00; // Outras regioes
        }
        
        // Aplica desconto de frete para clientes PJ
        if (tipoCliente.equals("PJ") && frete > 0) {
            frete = frete * 0.85; // 15% de desconto no frete
        }
        
        return frete;
    }
    
    private String extrairCep(String endereco) {
        // Simula extraçao do CEP do endereço
        if (endereco.contains("CEP:")) {
            int start = endereco.indexOf("CEP:") + 4;
            return endereco.substring(start, start + 5);
        }
        return "01000"; // CEP padrão
    }
    
    public double calcularImpostos() {
        double impostos = 0;
        
        // Calcula total dos itens
        double totalItens = 0;
        for (ItemPedido item : itens) {
            totalItens += item.getPreco() * item.getQuantidade();
        }
        
        // Imposto varia por tipo de cliente
        if (tipoCliente.equals("PF")) {
            // Pessoa Fisica: ICMS + ISS
            impostos = totalItens * 0.18; // 18% de impostos
        } else if (tipoCliente.equals("PJ")) {
            // Pessoa Juridica: ICMS + ISS + PIS/COFINS
            impostos = totalItens * 0.25; // 25% de impostos
        }
        
        // Imposto adicional para produtos eletronicos
        for (ItemPedido item : itens) {
            if (item.getCategoria().equals("ELETRONICO")) {
                impostos += item.getPreco() * item.getQuantidade() * 0.05; // 5% de imposto adicional
            }
        }
        
        return impostos;
    }
    
    public void calcularTotal() {
        double subtotal = 0;
        for (ItemPedido item : itens) {
            subtotal += item.getPreco() * item.getQuantidade();
        }
        
        double frete = calcularFrete();
        double impostos = calcularImpostos();
        
        this.valorTotal = subtotal + frete + impostos;
    }
    
    public void salvarNoBanco() {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // Conexao com banco 
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/loja",
                "root",
                "senha123"
            );
            
            // Inserir pedido
            String sql = "INSERT INTO pedidos (id, cliente, tipo_cliente, endereco, metodo_pagamento, valor_total) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, cliente);
            stmt.setString(3, tipoCliente);
            stmt.setString(4, enderecoEntrega);
            stmt.setString(5, metodoPagamento);
            stmt.setDouble(6, valorTotal);
            stmt.executeUpdate();
            
            // Inserir itens do pedido
            String sqlItem = "INSERT INTO itens_pedido (pedido_id, produto, quantidade, preco, categoria) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sqlItem);
            
            for (ItemPedido item : itens) {
                stmt.setInt(1, id);
                stmt.setString(2, item.getNome());
                stmt.setInt(3, item.getQuantidade());
                stmt.setDouble(4, item.getPreco());
                stmt.setString(5, item.getCategoria());
                stmt.executeUpdate();
            }
            
            System.out.println("Pedido " + id + " salvo no banco com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar pedido: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexao: " + e.getMessage());
            }
        }
    }
    
    public void enviarEmailConfirmacao() {
        // Configuracoes de e-mail 
        String servidorSMTP = "smtp.gmail.com";
        String usuario = "loja@empresa.com";
        String senha = "senha_email";
        
        System.out.println("=== ENVIANDO E-MAIL DE CONFIRMAÇAO ===");
        System.out.println("Servidor: " + servidorSMTP);
        System.out.println("De: " + usuario);
        System.out.println("Para: " + cliente + " <" + cliente.toLowerCase().replace(" ", "") + "@email.com>");
        System.out.println("Assunto: Pedido #" + id + " confirmado!");
        System.out.println("Corpo:");
        System.out.println("Olá " + cliente + ",");
        System.out.println("Seu pedido #" + id + " foi confirmado!");
        System.out.println("Valor total: R$ " + String.format("%.2f", valorTotal));
        System.out.println("Forma de pagamento: " + metodoPagamento);
        System.out.println("Endereco de entrega: " + enderecoEntrega);
        System.out.println("");
        System.out.println("Itens do pedido:");
        for (ItemPedido item : itens) {
            System.out.println("- " + item.getQuantidade() + "x " + item.getNome() + " (R$ " + item.getPreco() + ")");
        }
        System.out.println("================================");
        
        // Na vida real, enviaria e-mail de fato
    }
    
    public void gerarNotaFiscal() {
        System.out.println("\n=== NOTA FISCAL ===");
        System.out.println("Pedido #: " + id);
        System.out.println("Cliente: " + cliente + " (" + tipoCliente + ")");
        System.out.println("Data: " + new java.util.Date());
        System.out.println("-".repeat(50));
        
        double subtotal = 0;
        for (ItemPedido item : itens) {
            double itemTotal = item.getPreco() * item.getQuantidade();
            subtotal += itemTotal;
            System.out.printf("%d x %-20s R$ %7.2f = R$ %7.2f%n",
                item.getQuantidade(),
                item.getNome(),
                item.getPreco(),
                itemTotal
            );
        }
        
        System.out.println("-".repeat(50));
        System.out.printf("Subtotal: R$ %7.2f%n", subtotal);
        System.out.printf("Frete: R$ %7.2f%n", calcularFrete());
        System.out.printf("Impostos: R$ %7.2f%n", calcularImpostos());
        System.out.printf("TOTAL: R$ %7.2f%n", valorTotal);
        System.out.println("==================\n");
    }
    
    // Getters e Setters
    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public String getTipoCliente() { return tipoCliente; }
    public String getEnderecoEntrega() { return enderecoEntrega; }
    public String getMetodoPagamento() { return metodoPagamento; }
    public List<ItemPedido> getItens() { return itens; }
    public double getValorTotal() { return valorTotal; }
    
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }
}