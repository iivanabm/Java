package senhas;

public class Preferencial {

    private static int numero;
    private static int qtdSenhaPreferencial = 0;

    public Preferencial() {
        numero++;
        qtdSenhaPreferencial++;
    }

    public int getNumero() {
        return numero;
    }

    public int qtdSenhaPreferencial() {
        return qtdSenhaPreferencial;
    }

    @Override
    public String toString() {
        return "P" + numero;
    }

}
