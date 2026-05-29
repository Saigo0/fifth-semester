package templatemethod3;

import java.util.List;

public class AutorizadorCirurgia extends AutorizarServico{
    @Override
    protected boolean verificarCobertura(SolicitacaoServico solicitacao, List<String> log) {
        if(solicitacao.getServico().equals("CIRURGIA") && (solicitacao.getPrestador().getEspecialidade().equals("CIRURGIA GERAL") || solicitacao.getPrestador().getEspecialidade().equals("CARDIOLOGIA"))){
            log.add("Cobertura ok");
           return true;
        } else {
            log.add("Especialidade não coberta para cirurgias");
            return false;
        }
    }

    @Override
    protected boolean verificarCarencia(SolicitacaoServico solicitacao, List<String> log) {
        if(solicitacao.getPaciente().getDataAssociacao().isAfter(solicitacao.getDataSolicitacao().minusDays(180))){
            log.add("A carência mínima não está sendo cumprida.");
            return false;
        } else{
            log.add("Carência ok");
            return true;
        }

    }

    @Override
    protected boolean verificarLimiteAnual(SolicitacaoServico solicitacao, List<String> log) {
        if(solicitacao.getPaciente().getUsosAno("CIRURGIA") >= 2){
            log.add("Paciente está ultrapassando os usos anuais para cirurgias");
            return false;
        } else{
            log.add("Limite ok");
            return true;
        }

    }

    @Override
    protected double calcularValorPrestador(SolicitacaoServico solicitacao) {
        switch (solicitacao.getPaciente().getPlano()){
            case "BÁSICO":
                return 800.0;
            case "EXECUTIVO":
                return 1500.0;
            case "PREMIUM":
                return 3000.0;
            default:
                return 0;
        }
    }
}
