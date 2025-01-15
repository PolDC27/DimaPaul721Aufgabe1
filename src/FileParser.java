import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {
    public List<List<String>> readFromFile(String fileName) {
        // Path to the file
        Path filePath = Path.of(fileName);

        // Define a regex pattern for delimiters (e.g., comma, semicolon, tab, or space)
        String delimiterRegex = "\t";

        List<List<String>> readable_lines = new ArrayList<>();

        try {

            // Read all lines from the file
            Files.lines(filePath).forEach(line -> {
                // Split the line using the regex
                String[] entities = line.split(delimiterRegex);
                readable_lines.add(Arrays.asList(entities));
                // Print or process the entities
            });
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return readable_lines;
    }

    public static void main(String[] args) {
        FileParser fileParser = new FileParser();
        List<List<String>> data = fileParser.readFromFile("evenimente.tsv");
        for (List<String> line : data) {
            System.out.println(line);
        }
    }
}
