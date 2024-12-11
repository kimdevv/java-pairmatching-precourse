package pairmatching.utility;

import pairmatching.enumerate.ExceptionEnum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public static String getCrewNamesFromFile(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath));
            return bufferedReader.readLine();
        } catch (FileNotFoundException exception) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
        } catch (IOException exception2) {
            throw new IllegalArgumentException(ExceptionEnum.INVALID_INPUT.getMessage());
        }
    }
}
