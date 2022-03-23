import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private FileInputStream fis;
    private Scanner sc;

    public FileHandler(String fileName) {
        // Abre o arquivo
        try {
            fis = new FileInputStream(fileName);
        } catch(FileNotFoundException fnf) {
            fnf.printStackTrace();
        }

        // Cria um novo scanner para ler o arquivo
        sc = new Scanner(fis);
    }

    public ArrayList<String> getNextLine() {
        ArrayList<String> lines = new ArrayList<String>();

        // Se o arquivo possuir mais uma linha para ser lida, retorna o conteúdo da linha
        while(sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        return lines;
    }
}