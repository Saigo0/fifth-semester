package strategy3;

import strategy3.loja.CalculoDescontoAcimaTrezentos;
import strategy3.loja.CalculoDescontoPercentual;
import strategy3.loja.ItemVenda;
import strategy3.loja.Venda;

public class Sistema {

	public static void main(String[] args) {
		Venda v = new Venda(new CalculoDescontoPercentual());
		v.add(new ItemVenda(10, 100));
		v.add(new ItemVenda(1.2, 500));
		v.add(new ItemVenda(30, 300));
		
		System.out.println(v.pagar());

		Venda v2 = new Venda(new CalculoDescontoAcimaTrezentos());
		v2.add(new ItemVenda(10, 100));
		v2.add(new ItemVenda(1.2, 500));
		v2.add(new ItemVenda(30, 300));

		System.out.println(v2.pagar());

	}

}
