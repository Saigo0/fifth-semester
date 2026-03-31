package ex02.refatoracao;

public class ExtracaoCEP {
    public String extrairCep(String endereco) {
        // Simula extraçao do CEP do endereço
        if (endereco.contains("CEP:")) {
            int start = endereco.indexOf("CEP:") + 4;
            return endereco.substring(start, start + 5);
        }
        return "01000"; // CEP padrão
    }
}
