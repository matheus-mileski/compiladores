import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class GyhProgram {

    private SymbolTable varTable;
    private ArrayList<Command> command;

    public void setCommand(ArrayList<Command> commands) {
        this.command = commands;
    }

    public void setVarTable(SymbolTable varTable) {
        this.varTable = varTable;
    }

    public void generateTarget(String filename) {
        StringBuilder str = new StringBuilder();
        System.out.println("\n-> Código Gerado com Sucesso!!!\n\n");
        str.append("#include<stdio.h>\n");
        str.append("#include<stdlib.h>\n\n");

        str.append("void main(){\n\n");

        for (Symbol symbol : varTable.getAll()) {
            str.append(symbol.generateCode());
        }

        str.append("\n");

        for (Command cmd : command) {
            str.append(cmd.generateCode());
        }

        str.append("\n}");

        try {
            System.out.println(str);
            FileWriter file = new FileWriter(new File(filename + "_output.c"));
            file.write(str.toString());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
