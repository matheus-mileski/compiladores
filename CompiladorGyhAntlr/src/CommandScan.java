public class CommandScan extends Command{
    private String id;
    private int type;

    public CommandScan(String id, int type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String generateCode() {
        if (type == 0)
            return "\tscanf(\"%d\", &" + id + ");\n";

        return "\tscanf(\"%lf\", &" + id + ");\n";
    }
}
