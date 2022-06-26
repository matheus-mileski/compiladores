import java.util.ArrayList;

public class CommandCond extends Command {
    private String condition;
    private ArrayList<Command> listTrue;
    private ArrayList<Command> listFalse;

    public CommandCond(String condition, ArrayList<Command> listTrue, ArrayList<Command> listFalse) {
        this.condition = condition;
        this.listTrue = new ArrayList<>(listTrue);
        this.listFalse = new ArrayList<>(listFalse);;
    }

    @Override
    public String generateCode() {
        StringBuilder str = new StringBuilder("\tif(" + condition + "){\n");

        for (Command cmd : listTrue) {
            str.append("\t\t");
            str.append(cmd.generateCode());
        }

        str.append("\t}\n");

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
