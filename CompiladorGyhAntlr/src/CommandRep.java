// Classe para gerar o código do comando de repetição.

import java.util.ArrayList;
public class CommandRep extends Command {
    private String condition;   // Condição do while
    private ArrayList<Command> listRep; // Lista de comandos do while
    public CommandRep(String condition, ArrayList<Command> listCmd) {
        this.condition = condition;
        this.listRep = new ArrayList<>(listCmd);
    }
    @Override
    public String generateCode() {
        // Inicia a string da repetição
        StringBuilder str = new StringBuilder("\twhile(" + condition + "){\n");

        // Adiciona cada comando dentro da repetição
        for (Command cmd : listRep) {
            str.append("\t\t");
            str.append(cmd.generateCode());
        }

        str.append("\t}\n");

        return str.toString();
    }
}