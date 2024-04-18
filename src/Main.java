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

    public static void main(String[] args) {
        loadTextDocument("src/bookcipher.txt");
        String message = "A book cipher is properly called a spy";
        String encodedMessage = encodeMessage(message);
        System.out.println("Encoded message: " + encodedMessage);

        String decodedMessage = decodeMessage(encodedMessage);
        System.out.println("Decoded message: " + decodedMessage);
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

private static String decodeMessage(String encodedMessage) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] indices = encodedMessage.split("\\s+");
        for (String indexStr : indices) {
            try {
                int index = Integer.parseInt(indexStr);
                for (Map.Entry<String, Integer> entry : wordIndexMap.entrySet()) {
                    if (entry.getValue() == index) {
                        decodedMessage.append(entry.getKey()).append(" ");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                decodedMessage.append(indexStr).append(" ");
            }
        }
        return decodedMessage.toString().trim();
    }
}