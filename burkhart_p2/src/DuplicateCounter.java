import java.io.*;
import java.util.*;

public class DuplicateCounter {
    private HashMap<String, Integer> wordCounter = new HashMap<>();
    private String copy;
    int count = 0;

    public void count(String dataFile) throws IOException {
        try (FileReader input = new FileReader(dataFile)) {
            Scanner scnr = new Scanner(input);
            while (scnr.hasNext()) {
                copy = scnr.next();
                if (wordCounter.containsKey(copy)) {
                    count = wordCounter.get(copy);
                    wordCounter.put(copy, 1 + count);
                } else {
                    wordCounter.put(copy, 1);
                }
            }
        }
    }

    public void write(String outputFile) throws IOException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            writer.println(entry.getKey() + " = " + entry.getValue());
        }
        writer.close();
    }

}
