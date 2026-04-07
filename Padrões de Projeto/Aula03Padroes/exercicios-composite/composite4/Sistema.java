package composite4;


import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        Aeroporto poa = new Aeroporto("POA", 1800, 50);
        Aeroporto fln = new Aeroporto("FLN", 1800, 50);
        Aeroporto cwb = new Aeroporto("CWB", 1800, 50);
        Aeroporto cgh = new Aeroporto("CGH", 1800, 50);
        Aeroporto bsb = new Aeroporto("BSB", 1800, 50);

        Trecho poa_fln = new Trecho(poa, fln, 200.0, 3600.0);
        Trecho poa_fln_cwb = new Trecho(poa_fln, cwb, 300.0, 3600.0);
        Trecho poa_fln_cwb_cgh = new Trecho(poa_fln_cwb, cgh, 400.0, 3600.0);

        Trecho fln_cwb = new Trecho(fln, cwb, 600.0, 3600.0);

        List<LinhaAerea> lista = new ArrayList<LinhaAerea>();

        lista.add(poa_fln);
        lista.add(poa_fln_cwb);
        lista.add(poa_fln_cwb_cgh);
        lista.add(fln_cwb);
        lista.add(bsb);

        for (LinhaAerea linha : lista) {
            linha.imprimir();
        }

    }
}
