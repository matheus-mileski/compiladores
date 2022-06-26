public class Symbol {
    private String name;
    private int type;   // INT = 0, REAL = 1

    private boolean utilizada;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getTypeStr() {
        if (type == 0)
            return "INT";
        return "REAL";
    }

    public void setType(int type) {
        this.type = type;
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
        String str;

        if (type == INT) {
            return "\tint " + name + ";\n";
        }

        return "\tdouble " + name + ";\n";
    }
}
