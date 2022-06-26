import java.util.ArrayList;

public class Variavel {

    String nome;
    int tipo;
    boolean utilizada;

    public static final int INT = 0;
    public static final int REAL = 1;

    public Variavel(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public void setUtilizada() {
        this.utilizada = true;
    }
}
