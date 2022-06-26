public class CommandPrint extends Command {

    private String id;
    private int type;

    public CommandPrint(String id, int type) {
        this.id = id;
        this.type = type;
    }

    public CommandPrint(String id) {
        this.id = id;
    }

    @Override
    public String generateCode() {
        if (type == 0)
            return "\tprintf(\"%d\\n\", " + id + ");\n";
        else if (type == 1)
            return "\tprintf(\"%lf\\n\", " + id + ");\n";
        return "\tprintf(\"" + id.replace("\"","") + "\\n\");\n";
    }

}
