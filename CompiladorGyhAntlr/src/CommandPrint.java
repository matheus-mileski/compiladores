// Classe para gerar o código do comando de escrita.
public class CommandPrint extends Command {
    private String id;  // Nome da variável (ou cadeia de caracteres)
    private int type;   // Tipo da variável
    public CommandPrint(String id, int type) {
        this.id = id;
        this.type = type;
    }
    public CommandPrint(String id) {
        this.id = id;
    }
    @Override
    public String generateCode() {
        // Se o tipo for zero, imprime um inteiro (%d)
        if (type == 0)
            return "\tprintf(\"%d\\n\", " + id + ");\n";

        // Se o tipo for um, imprime um double (%lf)
        else if (type == 1)
            return "\tprintf(\"%lf\\n\", " + id + ");\n";

        // Se nao for zero nem um, imprime a cadeia de caracteres
        return "\tprintf(\"" + id.replace("\"","") + "\\n\");\n";
    }
}