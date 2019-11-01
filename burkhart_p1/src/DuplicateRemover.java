import java.io.*;
import java.util.*;

public class DuplicateRemover {
    private Set<String> uniqueWords = new HashSet<>();

    public void remove(String dataFile) throws IOException {
        try (FileReader input = new FileReader(dataFile)) {
            Scanner scnr = new Scanner(input);
            while (scnr.hasNext()) {
                uniqueWords.add(scnr.next());
            }
        }
    }

    public void write(String outputFile) throws IOException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (String WordOut : uniqueWords) {
            writer.println(WordOut);
        }
        writer.close();
    }

}
