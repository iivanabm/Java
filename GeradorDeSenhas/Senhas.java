package senhas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Senhas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<SenhasDeAtendimento> atendimento = new TreeSet<>();
        Map<String, Set<SenhasDeAtendimento>> todasAsSenhas = new TreeMap<>();
        String resposta;
        int qtdSenhaPreferencial = 0;
        int qtdSenhaGeral = 0;
        do {
            System.out.println("Senha preferencial? (s/n)");
            System.out.println("Digite qualquer outra tecla para sair da aplicação.");
            resposta = sc.next();

            if (resposta.equals("s")) {
                Preferencial preferencial = new Preferencial();
                SenhasDeAtendimento senha1 = new SenhasDeAtendimento(true);
                atendimento.add(senha1);
                todasAsSenhas.put("Preferencial", new TreeSet<>());
                DateTimeFormatter dtformatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
                LocalDateTime ldt = LocalDateTime.now();
                String format = dtformatter.format(ldt);
                qtdSenhaPreferencial = preferencial.qtdSenhaPreferencial();
                System.out.println("Senha: " + preferencial.toString() + "\nMomento da geração: " + format);
            } else if (resposta.equals("n")) {
                Geral geral = new Geral();
                SenhasDeAtendimento senha1 = new SenhasDeAtendimento(false);
                System.out.println(geral.toString());
                atendimento.add(senha1);
                todasAsSenhas.put("Geral", new TreeSet<>());
                DateTimeFormatter dtformatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
                LocalDateTime ldt = LocalDateTime.now();
                String format = dtformatter.format(ldt);
                qtdSenhaGeral = geral.qtdSenhaGeral();
                System.out.println("Senha: " + geral.toString() + "\nMomento da geração: " + format);
            }
        } while ((resposta.equals("s")) || (resposta.equals("n")));

        System.out.print("\nQuantidade de senhas para atendimento preferencial: ");
        System.out.println(qtdSenhaPreferencial);

        System.out.print("\nQuantidade de senhas para atendimento geral: ");
        System.out.println(qtdSenhaGeral);

        System.out.print("\nQuantidade total de senhas geradas: ");
        System.out.println(qtdSenhaPreferencial + qtdSenhaGeral);
    }

}
