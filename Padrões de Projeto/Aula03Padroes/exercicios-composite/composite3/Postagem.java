package composite3;

import composite2.Participante;

import java.util.ArrayList;
import java.util.List;

public class Postagem extends ComponenteSite {

    private List<ComponenteSite> componentes = new ArrayList<>();

    public void add(ComponenteSite componenteSite){
        componentes.add(componenteSite);
    }

    public void remove(ComponenteSite componenteSite){
        componentes.remove(componenteSite);
    }

    public ComponenteSite getComponenteSite(int i){
        return componentes.get(i);
    }

    public void imprimir(){
        for(ComponenteSite componenteSite : componentes){
            componenteSite.imprimir();
        }
    }


}
