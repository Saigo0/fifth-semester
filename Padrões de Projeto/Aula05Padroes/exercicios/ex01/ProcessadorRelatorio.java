package ex01;

import java.util.List;

public class ProcessadorRelatorio {

    //calcula os totais provindos da lista itens
    public double calcularTotais(List<ItemVenda> itens) {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getQuantidade() * item.getPrecoUnitario();
        }
        
        // Aplica desconto se total > 1000
        if (total > 1000) {
            total = total * 0.9;
        }
        
        return total;
    }

    //formata o cabeçalho
    public String formatarCabecalho(String titulo, String data) {
        StringBuilder sb = new StringBuilder();
        sb.append("=".repeat(50)).append("\n");
        sb.append(titulo).append("\n");
        sb.append("Data: ").append(data).append("\n");
        sb.append("=".repeat(50)).append("\n");
        return sb.toString();
    }

    //geraPDF
    public void gerarPDF(String conteudo, String nomeArquivo) {
        System.out.println("Gerando PDF: " + nomeArquivo);
        System.out.println("Conteúdo: " + conteudo);
        // Na vida real: iText, Apache PDFBox, etc.
    }

    //envia email
    public void enviarPorEmail(String destinatario, String assunto, String corpo) {
        // Simula envio de e-mail
        System.out.println("Enviando e-mail para: " + destinatario);
        System.out.println("Assunto: " + assunto);
        System.out.println("Corpo: " + corpo);
        // Na vida real: JavaMail, Spring Mail, etc.
    }
  
    //processa e envia o relatório
    public void processarEEnviarRelatorio(String titulo, String data, 
                                          List<ItemVenda> itens, 
                                          String destinatario) {
        double total = calcularTotais(itens);
        
        String cabecalho = formatarCabecalho(titulo, data);

        //Construir conteúdo do relatório
        StringBuilder conteudo = new StringBuilder();
        conteudo.append(cabecalho);
        conteudo.append("Total de vendas: R$ ").append(total).append("\n");
        conteudo.append("\nItens vendidos:\n");
        for (ItemVenda item : itens) {
            conteudo.append("- ").append(item.getNome())
                   .append(": ").append(item.getQuantidade())
                   .append(" x R$ ").append(item.getPrecoUnitario())
                   .append(" = R$ ").append(item.getQuantidade() * item.getPrecoUnitario())
                   .append("\n");
        }
        
        gerarPDF(conteudo.toString(), "relatorio_" + data + ".pdf");
        
        enviarPorEmail(destinatario, "Relatório: " + titulo, conteudo.toString());
    }
}

