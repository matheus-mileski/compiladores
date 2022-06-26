public class CommandAtrib extends Command {

    private String id;
    private String exp;

    public CommandAtrib(String id, String exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public String generateCode() {
        return "\t" + id + " = " + exp + ";\n";
    }
}
