package templatemethod3;

import java.util.List;

public class AutorizadorConsulta extends AutorizarServico{
    @Override
    protected boolean verificarCobertura(SolicitacaoServico solicitacao, List<String> log) {
        if(!solicitacao.getPrestador().getEspecialidade().equals("CIRURGIA GERAL") && !solicitacao.getPrestador().getEspecialidade().equals("FISIOTERAPIA")){
            log.add("Cobertura ok");
            return true;
        } else {
            log.add("Especialidade não coberta para consultas");
            return false;
        }
    }

    @Override
    protected boolean verificarCarencia(SolicitacaoServico solicitacao, List<String> log) {
        if(!solicitacao.getPaciente().getDataAssociacao().isAfter(solicitacao.getDataSolicitacao().minusDays(30))){
            log.add("A carência mínima não está sendo cumprida.");
            return false;
        } else {
            log.add("Carência ok");
            return true;
        }
    }

    @Override
    protected boolean verificarLimiteAnual(SolicitacaoServico solicitacao, List<String> log) {
        if(solicitacao.getPaciente().getUsosAno("CONSULTA") >= 12){
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
                return 50.0;
            case "EXECUTIVO":
                return 80.0;
            case "PREMIUM":
                return 120.0;
            default:
                return 0;
        }
    }

}
