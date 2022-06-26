import java.util.ArrayList;

public class CommandRep extends Command {
    private String condition;
    private ArrayList<Command> listRep;

    public CommandRep(String condition, ArrayList<Command> listCmd) {
        this.condition = condition;
        this.listRep = new ArrayList<>(listCmd);
    }

    @Override
    public String generateCode() {

        StringBuilder str = new StringBuilder("\twhile(" + condition + "){\n");

        for (Command cmd : listRep) {

            str.append("\t\t");
            str.append(cmd.generateCode());
        }

        str.append("\t}\n");

        return str.toString();
    }
}
