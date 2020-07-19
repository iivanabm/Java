package trabalho;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Map;
import java.util.stream.Collectors;

public class Trabalho {

    public static void main(String[] args) {

        Filme umsonho = new Filme("Um Sonho de Liberdade", 1994, 9.3);
        Filme opoderoso = new Filme("O Poderoso Chefão", 1972, 9.2);
        Filme batmanocavaleiro = new Filme("Batman: O Cavaleiro das Trevas", 2008, 9.0);
        Filme pulpfiction = new Filme("Pulp Fiction: Tempo de Violência", 1994, 8.9);
        Filme aorigem = new Filme("A Origem", 2010, 8.8);
        Filme osenhordosaneis = new Filme("O Senhor dos Aneis: A Sociedade do Anel", 2001, 8.8);
        Filme matrix = new Filme("Matrix", 1999, 8.7);
        Filme parasita = new Filme("Parasita", 2019, 8.6);
        Filme interestelar = new Filme("Interestelar", 2014, 8.6);
        Filme osilencio = new Filme("O Silêncio dos Inocentes", 1991, 8.6);

        List<Filme> lista = new ArrayList<>();

        lista.add(umsonho);
        lista.add(opoderoso);
        lista.add(batmanocavaleiro);
        lista.add(pulpfiction);
        lista.add(aorigem);
        lista.add(osenhordosaneis);
        lista.add(matrix);
        lista.add(parasita);
        lista.add(interestelar);
        lista.add(osilencio);

        Stream<Filme> streamFilmes = lista.stream()
                .filter(f -> f.getAno() > 2000 && f.getAno() <= 2010);

        Map<Double, List<Filme>> mapFilmes = streamFilmes
                .collect(Collectors.groupingBy(f -> f.getNota()));

        System.out.println(mapFilmes);
    }

}
