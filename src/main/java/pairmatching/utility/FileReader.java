package pairmatching.utility;

import pairmatching.enumerate.ExceptionEnum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static String getCrewNamesFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return String.join(System.lineSeparator(), lines);
        } catch (IOException exception) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
        }
    }
}
