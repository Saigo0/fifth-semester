public class Produto {

    private String id;
    private String nome;
    private double preco;
    private int estoque;
    private String categoria;

    public Produto(String id, String nome, double preco, int estoque, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    public String getCategoria() { return categoria; }

    public void setEstoque(int estoque) { this.estoque = estoque; }
    public void setPreco(double preco) { this.preco = preco; }
}
