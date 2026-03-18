package composite3;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        Pagina p1 = new Pagina("O último suspiro", "https://www.url.com", "Aopa");
        Pagina p2 = new Pagina("AOOOO", "https://www.url2.com", "Aooooooooopa");
        Pagina p3 = new Pagina("OAAAAAAAAAA", "https://www.url3.com", "Aopaaaaaa");

        Postagem post1 = new Postagem();

        post1.add(p1);
        post1.add(p2);

        List<ComponenteSite> componenteSites = new ArrayList<>();
        componenteSites.add(p3);
        componenteSites.add(post1);

        for (ComponenteSite c:componenteSites) {
            c.imprimir();
        }

    }
}
