package main;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.List;
import java.util.logging.Logger;
import java.util.Properties;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Properties properties = new Properties();
        String filePath;
        try (FileInputStream input = new FileInputStream(Main.class.getClassLoader().getResource("config.properties").getFile())) {
            properties.load(input);
            filePath = properties.getProperty("logFilePath");
            
            if (filePath == null || filePath.isEmpty()) {
                logger.info("Log file path not specified in properties file.");
                return;
            } else {
                logger.info("Log file path: " + filePath);
            }
        } catch (IOException e) {
            logger.info("Error loading properties file: " + e.getMessage());
            return;

        }
        try{
            List<String> logLines = FileReaderUtil.readStrings(filePath);
            List<LogEntry> logEntries = LogParser.parseLogs(logLines);
            LogStats logStats = new LogStats(logEntries);
            logStats.calculateStats();
            logStats.printStats();
        }
        catch (IOException e) {
            logger.info(filePath + " not found");
        }
        catch (Exception e) {
            logger.info("Error: " + e.getMessage());
        }
    }
}