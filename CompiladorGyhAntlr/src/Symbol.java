public class Symbol {
    private String name;
    private int type;   // INT = 0, REAL = 1
    private String value;

    public Symbol(String name, int type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
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

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (type == 0)
            return ("Simbolo: (nome: " + name + ", tipo: INT, valor: " + value + ")");
        else
            return ("Simbolo: (nome: " + name + ", tipo: REAL, valor: " + value + ")");
    }
}
