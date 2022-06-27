// Classe para representar um simbolo (variável)
public class Symbol {
    private String name;    // Nome da variável
    private int type;   // Tipo da variável -> INT = 0, REAL = 1
    private boolean utilizada;  // Indicador se a variável foi utilizada no programa
    public static final int INT = 0;
    public static final int REAL = 1;

    public Symbol(String name, String type) {
        this.name = name;

        if (type.equals("INT"))
            this.type = INT;
        else
            this.type = REAL;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getTypeStr() {
        // Retorna o tipo da variável
        if (type == 0)
            return "INT";

        return "REAL";
    }

    public void setUtilizada() {
        this.utilizada = true;
    }

    public boolean foiUtilizada() {
        return utilizada;
    }

    @Override
    public String toString() {
        if (this.type == 0) {
            return ("Simbolo: (nome: " + name + ", tipo: INT)");
        } else {
            return ("Simbolo: (nome: " + name + ", tipo: REAL)");
        }
    }

    public String generateCode() {
        // Retorna o códico em C para a declaração da variável

        if (type == INT) {
            return "\tint " + name + ";\n";
        }

        return "\tdouble " + name + ";\n";
    }
}