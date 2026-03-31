package composite4;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        Aeroporto a = new Aeroporto();
        Aeroporto b = new Aeroporto();
        Aeroporto c = new Aeroporto();
        Aeroporto d = new Aeroporto();

        ConjuntoAeroportos conjunto = new ConjuntoAeroportos();

        conjunto.addLinha(a);
        conjunto.addLinha(b);

        List<LinhaAerea> linhasAereas = new ArrayList<>();
        linhasAereas.add(conjunto);
        linhasAereas.add(c);
        linhasAereas.add(d);

        for (LinhaAerea linhaAerea : linhasAereas) {
            linhaAerea.imprimir();
        }
    }
}
