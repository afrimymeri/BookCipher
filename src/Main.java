import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static void loadTextDocument(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 1;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word: words) {
                }
            }
        }catch (IOException e) {

        }
    }
}
