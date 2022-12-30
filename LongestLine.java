package lab5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class LongestLine {
    public static void getLongestLine(String inputPath) {
        Path path = Path.of(inputPath);
        try {
            List<String> lines = Files.readAllLines(path);
            if(!lines.isEmpty()) {
                Stream<String> sortedLines = lines.stream().sorted(Comparator.comparing(String::length).reversed());
                Optional<String> longestLine = sortedLines.findFirst();
                if (longestLine.isPresent()) {
                    System.out.println("Найдовший рядок: " + longestLine.get());
                } else {
                    System.out.println("No value");
                }
            } else {
                System.out.println("Помилка");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
