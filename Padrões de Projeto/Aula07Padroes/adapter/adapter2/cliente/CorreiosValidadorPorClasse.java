package adapter2.cliente;

import adapter2.brasileiro.CorreiosValidador;

public class CorreiosValidadorPorClasse extends CorreiosValidador implements ValidadorEndereco {

	@Override
	public void validar(Cliente cliente) throws Exception {
		super.validar(cliente.getCep(), cliente.getEstado());
	}

}
