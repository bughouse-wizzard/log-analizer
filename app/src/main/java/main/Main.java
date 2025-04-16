package main;

import java.io.IOException;
import java.util.List;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/pr0xi/Documents/GitHub/python_calculator/fork_1/log-analizer/app/src/test/testLogFile.txt";
        try{
            List<String> logLines = FileReaderUtil.readStrings(filePath);
            List<LogEntry> logEntries = LogParser.parseLogs(logLines);
            LogStats logStats = new LogStats(logEntries);
            logStats.calculateStats();
            logStats.printStats();
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}