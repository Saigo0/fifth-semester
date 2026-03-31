package ex01.refatoracao;

public class GeracaoPDFRelatorio {
    public void gerarPDF(String conteudo, String nomeArquivo) {
        System.out.println("Gerando PDF: " + nomeArquivo);
        System.out.println("Conteúdo: " + conteudo);
        // Na vida real: iText, Apache PDFBox, etc.
    }
}
