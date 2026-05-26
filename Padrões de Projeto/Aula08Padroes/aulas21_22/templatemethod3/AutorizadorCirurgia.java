package templatemethod3;

import java.util.List;

public class AutorizadorCirurgia extends AutorizarServico{
    @Override
    protected boolean verificarCobertura(SolicitacaoServico solicitacao, List<String> log) {
        return solicitacao != null && !solicitacao.getServico().equals("FISIOTERAPIA") && !solicitacao.getServico().equals("CIRURGIA GERAL");
    }

    @Override
    protected boolean verificarCarencia(SolicitacaoServico solicitacao, List<String> log) {
        return false;
    }

    @Override
    protected boolean verificarLimiteAnual(SolicitacaoServico solicitacao, List<String> log) {
        return false;
    }

    @Override
    protected double calcularValorPrestador(SolicitacaoServico solicitacao) {
        return 0;
    }
}
