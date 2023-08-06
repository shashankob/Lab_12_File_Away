import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Path selectPath = Paths.get(selectedFile.getAbsolutePath());
            List<String> lines = Files.readAllLines(selectPath);

            int lineNumber = 0;
            int wordNumber = 0;
            int chaNumber = 0;

            for (String line : lines) {
                lineNumber++;
                String[] words = line.split(" ");
                wordNumber += words.length;
                chaNumber += line.length();
            }

            System.out.println("File Name: " + selectedFile.getName());
            System.out.println("The number of lines in this file: " + lineNumber);
            System.out.println("The number of words in this file: " + wordNumber);
            System.out.println("The number of characters in this file: " + chaNumber);
        }
    }
}
