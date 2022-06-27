// Classe para gerar o código do comando de atribuição.
public class CommandAtrib extends Command {
    private String id;  // Nome da variável
    private String exp; // Expressão aritimética

    public CommandAtrib(String id, String exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public String generateCode() {
        return "\t" + id + " = " + exp + ";\n";
    }
}