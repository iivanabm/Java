package senhas;

public class Geral {

    private static int numero;
    private static int qtdSenhaGeral = 0;

    public Geral() {
        numero++;
        qtdSenhaGeral++;
    }

    public int getNumero() {
        return numero;
    }

    public int qtdSenhaGeral() {
        return qtdSenhaGeral;
    }

    @Override
    public String toString() {
        return "G" + numero;
    }

}
