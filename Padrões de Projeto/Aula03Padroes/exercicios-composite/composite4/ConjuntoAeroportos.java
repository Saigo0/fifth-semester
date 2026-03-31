package composite4;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoAeroportos extends LinhaAerea {
    private List<LinhaAerea> linhasAeroportos = new ArrayList<LinhaAerea>();

    public void addLinha(LinhaAerea aeroporto) {
        linhasAeroportos.add(aeroporto);
    }

    public void removeLinha(LinhaAerea aeroporto) {
        linhasAeroportos.remove(aeroporto);
    }

    public LinhaAerea getAeroporto(int index) {
        return linhasAeroportos.get(index);
    }

    public double calcTempoTotal() {
        double tempoTotal = 0;
        for(LinhaAerea aeroporto : linhasAeroportos) {
            tempoTotal += aeroporto.calcTempoTotal();
        }
        return tempoTotal;
    }

    public double calcPrecoTotal() {
        double precoTotal = 0;
        for (LinhaAerea aeroporto : linhasAeroportos) {
            precoTotal += aeroporto.calcTempoTotal();
        }
        return precoTotal;
    }

    public void imprimir() {
        for (LinhaAerea aeroporto : linhasAeroportos) {
            aeroporto.imprimir();
        }

        System.out.println("Preço total: " + calcPrecoTotal());
        System.out.println("Tempo total: " + calcTempoTotal());
    }

}
