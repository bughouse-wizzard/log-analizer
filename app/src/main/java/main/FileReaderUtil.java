package main;

import java.io.*;
import java.util.*;

public class FileReaderUtil {
    private FileReaderUtil() {
    }
    public static List<String> readStrings(String filePath) throws IOException{
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null){
                lines.add(line);
            }
        }
        return lines;
    }
}
