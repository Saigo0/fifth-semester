package ex01.refatoracao;

public class ItemVenda {
    private String nome;
    private int quantidade;
    private double precoUnitario;
    
    public ItemVenda(String nome, int quantidade, double precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
    
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }
}