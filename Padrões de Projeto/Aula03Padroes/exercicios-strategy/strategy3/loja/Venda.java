package strategy3.loja;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	private CalculoDesconto calculoDesconto;
	private List<ItemVenda> itens = new ArrayList<>();
	
	public void add(ItemVenda item) {
		itens.add(item);
	}
	
	public double getValorTotalBruto() {
		double res = 0;
		for (ItemVenda item:itens)
			res += item.getPrecoUnit()*item.getQtdade();
		return res;
	}
	public Venda(CalculoDesconto calculoDesconto){
		this.calculoDesconto = calculoDesconto;
	}
	public double getValorTotalAPagar() {
		return getValorTotalBruto();
	}

	public double pagar() {
		return calculoDesconto.calcularDesconto(this);
	}
	
}
