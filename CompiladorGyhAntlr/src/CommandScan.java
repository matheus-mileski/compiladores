// Classe para gerar o código do comando de entrada.
public class CommandScan extends Command{
    private String id;  // Nome da variável
    private int type;   // Tipo da variável
    public CommandScan(String id, int type) {
        this.id = id;
        this.type = type;
    }
    @Override
    public String generateCode() {
        // Se a variável for inteira, le um inteiro (%d)
        if (type == 0)
            return "\tscanf(\"%d\", &" + id + ");\n";

        // Se a variável for real, le um double (%lf)
        return "\tscanf(\"%lf\", &" + id + ");\n";
    }
}