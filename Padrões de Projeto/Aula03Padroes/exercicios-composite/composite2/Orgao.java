package composite2;

import java.util.ArrayList;
import java.util.List;

public class Orgao extends Participante {

	private List<Participante> membros = new ArrayList<>();
	
	public void add(Participante participante) {
		membros.add(participante);
	}
	
	public void remove(Participante participante) {
		membros.remove(participante);
	}
	
	public Participante getParticipante(int index) {
		return membros.get(index);
	}

	@Override
	public boolean votarSecao(int numSecao) {
		double votosTrue = 0;
		double votosFalse = 0;

		for (Participante participante : membros) {
			if (participante.votarSecao(numSecao)) {
				votosTrue++;
			} else{
				votosFalse++;
			}
		}
		return votosTrue > votosFalse;
	}
	
}
