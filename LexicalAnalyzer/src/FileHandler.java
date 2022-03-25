import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private FileInputStream fis;
    private Scanner sc;

    // Construtor que abre o arquivo
    public FileHandler(String fileName) {
        try {
            fis = new FileInputStream(fileName);
        } catch(FileNotFoundException fnf) {
            fnf.printStackTrace();
        }

        // Cria um novo scanner para ler o arquivo
        sc = new Scanner(fis);
    }

    // Metodo para ler todas as linhas do arquivo e retorna-los em uma lista
    public ArrayList<String> getLines() {
        ArrayList<String> lines = new ArrayList<String>();

        while(sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        return lines;
    }
}