import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, Integer> wordIndexMap = new HashMap<>();
    private static void loadTextDocument(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int index = 1;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word: words) {
                    wordIndexMap.put(word.toUpperCase(), index++);
                }
            }
        }catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


    private static String encodeMessage(String message) {
        StringBuilder encodedMessage = new StringBuilder();
        String[] words = message.split("\\s+");
        for (String word : words) {
            Integer index = wordIndexMap.get(word.toUpperCase());
            if (index != null) {
                encodedMessage.append(index).append(" ");
            } else {
                encodedMessage.append(word).append(" ");
            }
        }
        return encodedMessage.toString().trim();
    }
