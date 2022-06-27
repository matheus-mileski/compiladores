// Classe para gerar o código do comando de condicional.

import java.util.ArrayList;

public class CommandCond extends Command {
    private String condition;   // Condição do if
    private ArrayList<Command> listTrue;    // Lista de comandos se a condição for verdadeira
    private ArrayList<Command> listFalse;   // Lista de comandos se a condição for falsa

    public CommandCond(String condition, ArrayList<Command> listTrue, ArrayList<Command> listFalse) {
        this.condition = condition;
        this.listTrue = new ArrayList<>(listTrue);
        this.listFalse = new ArrayList<>(listFalse);
        ;
    }

    @Override
    public String generateCode() {
        // Inicia o string da condição
        StringBuilder str = new StringBuilder("\tif(" + condition + "){\n");

        // Adiciona cada comando na lista de comandos se a expressão for verdadeira
        for (Command cmd : listTrue) {
            str.append("\t\t");
            str.append(cmd.generateCode());
        }

        str.append("\t}\n");

        // Se a lista de comandos se a expressão for falsa nao for nula, adiciona os comandos no string
        if (listFalse.size() > 0) {
            str.append("\telse{\n");

            for (Command cmd : listFalse) {
                str.append("\t\t");
                str.append(cmd.generateCode());
            }

            str.append("\t}\n");
        }

        return str.toString();
    }
}