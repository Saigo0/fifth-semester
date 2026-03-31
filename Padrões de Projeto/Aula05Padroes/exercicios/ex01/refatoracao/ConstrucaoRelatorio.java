package ex01.refatoracao;

import ex01.ItemVenda;

import java.util.List;

public class ConstrucaoRelatorio {

    private CalculoRelatorio calculoRelatorio;

    public ConstrucaoRelatorio(){
        calculoRelatorio = new CalculoRelatorio();
    }

    public String formatarCabecalho(String titulo, String data) {
        StringBuilder sb = new StringBuilder();
        sb.append("=".repeat(50)).append("\n");
        sb.append(titulo).append("\n");
        sb.append("Data: ").append(data).append("\n");
        sb.append("=".repeat(50)).append("\n");
        return sb.toString();
    }

    public String construirRelatorio(String titulo, String data,
                                     List<ItemVenda> itens){

        StringBuilder conteudo = new StringBuilder();

        String cabecalho = formatarCabecalho(titulo, data);

        conteudo.append(cabecalho);
        conteudo.append("Total de vendas: R$ ").append(this.calculoRelatorio.calcularTotais(itens)).append("\n");
        conteudo.append("\nItens vendidos:\n");
        for (ItemVenda item : itens) {
            conteudo.append("- ").append(item.getNome())
                    .append(": ").append(item.getQuantidade())
                    .append(" x R$ ").append(item.getPrecoUnitario())
                    .append(" = R$ ").append(item.getQuantidade() * item.getPrecoUnitario())
                    .append("\n");
        }
        return conteudo.toString();
    }
}
