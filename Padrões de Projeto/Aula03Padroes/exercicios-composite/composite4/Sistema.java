package composite4;


import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        Aeroporto poa = new Aeroporto("POA");
        Aeroporto fln = new Aeroporto("FLN");
        Aeroporto cwb = new Aeroporto("CWB");
        Aeroporto cgh = new Aeroporto("CGH");

        Trecho poa_fln = new Trecho(poa, fln, 200.0, 3600.0);
        Trecho poa_fln_cwb = new Trecho(poa_fln, cwb, 300.0, 7200.0);
        Trecho poa_fln_cwb_cgh = new Trecho(poa_fln_cwb, cgh, 400.0, 10800.0);

        Trecho fln_cwb = new Trecho(fln, cwb, 600.0, 12000.0);

        List<LinhaAerea> lista = new ArrayList<LinhaAerea>();

        lista.add(poa_fln);
        lista.add(poa_fln_cwb);
        lista.add(poa_fln_cwb_cgh);
        lista.add(fln_cwb);

        for (LinhaAerea linha : lista) {
            linha.imprimir();
        }

    }
}
