import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.HashSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    // Method to encode a message
    // Method to encode a message
    // Method to encode a message
    public String encode(String message) {
        List<String> bookLines = readBook();
        StringBuilder encodedMessage = new StringBuilder();
        int currentPage = 1;
        int currentLine = 0;
        String[] words = message.split("\\s+");
        Set<String> encodedWords = new HashSet<>(); // Set to keep track of encoded words

        for (String line : bookLines) {
            currentLine++;
            if (currentLine > linesPerPage) {
                currentPage++;
                currentLine = 1;
            }
            int currentWord = 0; // Reset currentWord for each line
            String[] wordsInLine = line.split("\\s+");
            for (String word : wordsInLine) {
                currentWord++;
                for (int i = 0; i < words.length; i++) {
                    if (!encodedWords.contains(words[i]) && word.equalsIgnoreCase(words[i])) {
                        encodedMessage.append(currentPage).append(" ").append(currentLine).append(" ").append(currentWord).append(" ");
                        encodedWords.add(words[i]); // Add the encoded word to the set
                        break;
                    }
                }
            }
        }
        return encodedMessage.toString().trim();
    }






    // Method to decode a message (not implemented for this version)
    public String decode(String encodedMessage) {
        return "Decoding not implemented for this version.";
    }

    public static void main(String[] args) {
        // Example usage
        String txtFilePath = "src/librilibri.txt"; // Replace with the actual file path of your book
        int linesPerPage = 20;
        BookCipheri cipher = new BookCipheri(txtFilePath, linesPerPage);

        // Message to encode
        String messageToEncode = "When called impotent";

        // Encoding the message
        String encodedMessage = cipher.encode(messageToEncode);
        System.out.println("Encoded message: " + encodedMessage);
    }
}
