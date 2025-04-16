package main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Logger;

public class LogParser {
    private LogParser() {
    }        
    private static final Pattern logPattern = Pattern.compile("\\[(.*?)\\]\\s+(INFO||ERROR|WARN)\\s+(.*)");
    private static final Logger logger = Logger.getLogger(LogParser.class.getName());
    public static List<LogEntry> parseLogs(List<String> logLines){
        List<LogEntry> logEntries = new ArrayList<>();
        for (String line : logLines){
            Matcher matcher = logPattern.matcher(line);
            if (matcher.find()) {
                String timestamp = matcher.group(1);
                String level = matcher.group(2);
                String message = matcher.group(3);
                logEntries.add(new LogEntry(timestamp, level, message));
            }else{
                logger.warning("Invalid log entry: " + line);
            }
        }
        return logEntries;
    }
}