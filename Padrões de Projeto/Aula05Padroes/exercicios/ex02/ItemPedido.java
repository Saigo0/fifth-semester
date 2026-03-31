package ex02;

public class ItemPedido {
    private String nome;
    private int quantidade;
    private double preco;
    private String categoria; // "ELETRONICO", "ROUPA", "ALIMENTO", etc.
    
    public ItemPedido(String nome, int quantidade, double preco, String categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
    }
    
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
    public double getPreco() { return preco; }
    public String getCategoria() { return categoria; }
    
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public void setPreco(double preco) { this.preco = preco; }
}
