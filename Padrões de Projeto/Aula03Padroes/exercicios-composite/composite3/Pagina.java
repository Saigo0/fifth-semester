package composite3;

public class Pagina extends ComponenteSite {
    private String conteudo;

    public Pagina(String titulo, String url, String conteudo){
        this.setTitulo(titulo);
        this.setUrl(url);
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void imprimir(){
        System.out.println("Título: " + this.getTitulo() + "\nURL: " + this.getUrl() + "\nConteúdo: " + this.getConteudo() + "\n\n");
    }

}
