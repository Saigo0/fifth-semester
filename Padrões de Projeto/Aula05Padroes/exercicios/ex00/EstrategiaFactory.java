package ex00;

public class EstrategiaFactory {
    public static CalculoEstrategia criarEstrategia(String tipoCliente){
        if(tipoCliente.equals("PF")){
            return new CalculoEstrategiaPF();
        } else if(tipoCliente.equals("PJ")){
            return new CalculoEstrategiaPJ();
        }

        throw new RuntimeException("Tipo de cliente não suportado");
    }
}
