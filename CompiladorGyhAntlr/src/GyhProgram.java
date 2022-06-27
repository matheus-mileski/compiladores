// Classe para gerar o código em C do programa Gyh

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
public class GyhProgram {
    private SymbolTable varTable;   // Lista de variáveis declaradas
    private ArrayList<Command> command; // Lista de comandos
    public void setCommand(ArrayList<Command> commands) {
        this.command = commands;
    }
    public void setVarTable(SymbolTable varTable) {
        this.varTable = varTable;
    }
    public void generateTarget(String filename) {
        // Inicia um string com o conteúdo a ser escrito no arquivo
        StringBuilder str = new StringBuilder();
        System.out.println("\n-> Código Gerado com Sucesso!!!\n\n");

        // Adiciona as bibliotecas no arquivo
        str.append("#include<stdio.h>\n");
        str.append("#include<stdlib.h>\n\n");

        // Adiciona a função main
        str.append("void main(){\n\n");

        // Adiciona as variáveis
        for (Symbol symbol : varTable.getAll()) {
            str.append(symbol.generateCode());
        }

        str.append("\n");

        // Adiciona os comandos
        for (Command cmd : command) {
            str.append(cmd.generateCode());
        }

        str.append("\n}");

        // Escreve a string em um arquivo de saída .c
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