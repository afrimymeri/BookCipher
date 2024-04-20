import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BookCipheri {
    private String bookFilePath; // The file path of the book
    private int linesPerPage; // Number of lines per page

    // Constructor to initialize the book file path and lines per page
    public BookCipheri(String bookFilePath, int linesPerPage) {
        this.bookFilePath = bookFilePath;
        this.linesPerPage = linesPerPage;
    }

    // Method to read the book text from file
    private List<String> readBook() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(bookFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // Method to encode a message
    // Method to encode a message
    // Method to encode a message
    public String encode(String message) {
        List<String> bookLines = readBook();
        StringBuilder encodedMessage = new StringBuilder();
        int currentPage = 1;
        int currentLine = 0;
        String[] words = message.split("\\s+");
        Map<String, List<String>> wordPositions = new HashMap<>(); // Map to store word positions

        for (String word : words) {
            List<String> positions = new ArrayList<>();
            for (int i = 0; i < bookLines.size(); i++) {
                currentLine++;
                if (currentLine > linesPerPage) {
                    currentPage++;
                    currentLine = 1;
                }
                String[] wordsInLine = bookLines.get(i).split("\\s+");
                for (int j = 0; j < wordsInLine.length; j++) {
                    String bookWord = wordsInLine[j];
                    if (word.equalsIgnoreCase(bookWord)) {
                        positions.add(currentPage + " " + currentLine + " " + (j + 1));
                    }
                }
            }
            // Shuffle the positions if the word appears more than once
            if (positions.size() > 1) {
                Collections.shuffle(positions);
            }
            wordPositions.put(word.toLowerCase(), positions);
            // Reset page and line for the next word
            currentPage = 1;
            currentLine = 0;
        }

        for (String word : words) {
            List<String> positions = wordPositions.get(word.toLowerCase());
            if (positions != null && !positions.isEmpty()) {
                String[] position = positions.get(0).split("\\s+");
                encodedMessage.append(position[0]).append(" ");
                encodedMessage.append(position[1]).append(" ");
                encodedMessage.append(position[2]).append(" ");
                positions.remove(0); // Remove the used position only after encoding
            }
        }

        return encodedMessage.toString().trim();
    }



    // Method to decode a message
    // Method to decode a message
    public String decode(String encodedMessage) {
        List<String> bookLines = readBook();
        StringBuilder decodedMessage = new StringBuilder();
        String[] encodedWords = encodedMessage.split("\\s+");
        for (int i = 0; i < encodedWords.length; i += 3) {
            int page = Integer.parseInt(encodedWords[i]);
            int line = Integer.parseInt(encodedWords[i + 1]);
            int wordIndex = Integer.parseInt(encodedWords[i + 2]);
            boolean wordFound = false;

            for (int j = 0; j < bookLines.size(); j++) {
                if (page == 0 || line == 0 || wordIndex == 0) break;
                int lineIndex = (page - 1) * linesPerPage + line - 1;
                if (lineIndex < bookLines.size()) {
                    String[] wordsInLine = bookLines.get(lineIndex).split("\\s+");
                    if (wordIndex >= 1 && wordIndex <= wordsInLine.length) {
                        decodedMessage.append(wordsInLine[wordIndex - 1]).append(" ");
                        wordFound = true;
                        break;
                    }
                }
            }

            if (!wordFound) {
                // If the word is not found, append a placeholder
                decodedMessage.append("[WORD NOT FOUND]").append(" ");
            }
        }
        return decodedMessage.toString().trim();
    }


    public static void main(String[] args) {
        // Example usage
        String txtFilePath = "src/librilibri.txt"; // Replace with the actual file path of your book
        int linesPerPage = 20;
        BookCipheri cipher = new BookCipheri(txtFilePath, linesPerPage);

        // Message to encode
        String messageToEncode = "When called impotent une North regarded";

        // Encoding the message
        String encodedMessage = cipher.encode(messageToEncode);
        System.out.println("Encoded message: " + encodedMessage);

        // Decoding the message
        String decodedMessage = cipher.decode(encodedMessage);
        System.out.println("Decoded message: " + decodedMessage);
    }
}
