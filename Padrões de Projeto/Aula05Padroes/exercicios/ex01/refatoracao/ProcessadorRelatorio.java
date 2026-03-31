package ex01.refatoracao;

import ex01.ItemVenda;

import java.util.List;

public class ProcessadorRelatorio {


    /*calcula os totais provindos da lista itens
    public double calcularTotais(List<ItemVenda> itens) {
        CalculoRelatorio cr = new CalculoRelatorio();
        return cr.calcularTotais(itens);
    }*/

    /*formata o cabeçalho
    public String formatarCabecalho(String titulo, String data) {
        ConstrucaoRelatorio cr = new ConstrucaoRelatorio();
        cr.formatarCabecalho(titulo, data);
    }*/

    //geraPDF
    public void gerarPDF(String conteudo, String nomeArquivo) {
        GeracaoPDFRelatorio gpdf = new GeracaoPDFRelatorio();
        gpdf.gerarPDF(conteudo, nomeArquivo);
    }

    //envia email
    public void enviarPorEmail(String destinatario, String assunto, String corpo) {
        EnvioRelatorio er = new EnvioRelatorio();
        er.enviarPorEmail(destinatario, assunto, corpo);
    }
  
    //processa e envia o relatório
    public void processarEEnviarRelatorio(String titulo, String data, 
                                          List<ItemVenda> itens, 
                                          String destinatario) {
        ConstrucaoRelatorio cr = new ConstrucaoRelatorio();

        //Construir conteúdo do relatório
        String conteudo = cr.construirRelatorio(titulo, data, itens);


        gerarPDF(conteudo, "relatorio_" + data + ".pdf");
        
        enviarPorEmail(destinatario, "Relatório: " + titulo, conteudo);
    }
}

