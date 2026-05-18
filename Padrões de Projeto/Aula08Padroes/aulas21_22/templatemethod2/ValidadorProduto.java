package templatemethod2;

import java.util.ArrayList;
import java.util.List;

public class ValidadorProduto extends ValidadorDados{
    @Override
    protected List<String> validarFormato(List<String> data) {
        List<String> errors = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.split(";");
            if (parts.length != 4) {
                errors.add("Linha " + (i+1) + ": formato inválido (esperado: código;preço;estoque;nome) - recebido: " + line);
            }
        }
        return errors;
    }

    //Código não pode ser vazio
    //Preço deve ser maior que zero(formato decimal com ponto)
    //Estoque deve ser >= 0
    //Nome com pelo menos 3 caracteres

    @Override
    protected List<String> validarRegrasNegocio(List<String> data) {
        List <String> errors = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String[] parts = data.get(i).split(";");
            if (parts.length < 4) continue;

            String codigo = parts[0];
            try{
                double preco = Double.parseDouble(parts[1]);
                if (preco <= 0.0) {
                    errors.add("Linha " + (i+1) + ": preço menor ou igual a zero. Preço: " + preco);
                }
            } catch (NumberFormatException e) {
                errors.add("Erro ao converter valor: " + parts[1]);
            }


            int estoque = Integer.parseInt(parts[2]);
            String nome = parts[3];

            if (codigo == null || codigo.trim().isEmpty()) {
                errors.add("Linha " + (i+1) + ": código não pode ser vazio. Código: " + codigo);
            }

            if (estoque < 0) {
                errors.add("Linha " + (i+1) + ": Estoque inválido, pois é menor que 0. Estoque: " + estoque);
            }
            if (nome.length() < 3) {
                errors.add("Linha " + (i+1) + ": Nome inválido, pois possui menos do que 3 caracteres. " +nome);
            }
        }
        return errors;
    }
}
