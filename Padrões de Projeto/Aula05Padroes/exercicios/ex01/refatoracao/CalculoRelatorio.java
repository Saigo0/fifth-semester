package ex01.refatoracao;

import ex01.ItemVenda;

import java.util.List;

public class CalculoRelatorio {
    public double calcularTotais(List<ex01.ItemVenda> itens) {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getQuantidade() * item.getPrecoUnitario();
        }

        // Aplica desconto se total > 1000
        total = aplicarDesconto(total);

        return total;
    }

    public double aplicarDesconto(double total){
        if(total > 1000){
            return total * 0.9;
        }
        return total;
    }
}
