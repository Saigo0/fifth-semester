package adapter1.sistemavendas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import adapter1.adapterdeclasse.AmericanExpressDeClasse;
import adapter1.adapterdeclasse.MasterCardDeClasse;
import adapter1.adapterdeclasse.VisaDeClasse;
import adapter1.adapterdeobjeto.AmericanExpressDeObjeto;
import adapter1.adapterdeobjeto.MasterCardDeObjeto;
import adapter1.adapterdeobjeto.VisaDeObjeto;

public class SistemaVendas {

	public static void main(String[] args) {
		
		Map<Integer, Cartao> tipoCartao = new HashMap<>();
		tipoCartao.put(1, new MasterCardDeObjeto());
		tipoCartao.put(2, new VisaDeObjeto());
		tipoCartao.put(3, new AmericanExpressDeObjeto());
		tipoCartao.put(4, new MasterCardDeClasse());
		tipoCartao.put(5, new VisaDeClasse());
		tipoCartao.put(6, new AmericanExpressDeClasse());
		
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.print("De Objeto: (1-Mastercard 2-Visa 3-American Express). De Classe : (4-Mastercard 5-Visa 6-American Express)");
			int op = in.nextInt();
			Cartao c = tipoCartao.get(op);
			if (c == null) {
				System.out.println("Fim da aplicacao");
				in.close();

				System.exit(0);
			}
			System.out.print("Valor : ");
			int valor = in.nextInt();
			try {
				c.pagar("Xico", "98765432101234567", valor, "01/2025");
			} catch (Exception e) {
				System.out.println("Pagamento com problemas");
				e.printStackTrace();
			}
			
		} while (true);

	}

}
