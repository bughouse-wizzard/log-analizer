package main;

import java.util.List;
import java.util.logging.Logger;

public class LogStats {
    private List <LogEntry> logEntries;
    private int errorCount;
    private int warningCount;
    private int infoCount;
    private static final Logger logger = Logger.getLogger(LogStats.class.getName());

    public LogStats(List<LogEntry> logEntries) {
        this.logEntries = logEntries;
        this.errorCount = 0;
        this.warningCount = 0;
        this.infoCount = 0;
    }
    public void calculateStats(){
        for (LogEntry entry : logEntries){
            String level = entry.getLevel();
            if (level.equals("ERROR")) {
                errorCount++;
            }
            else if(level.equals("WARN")) {
                warningCount++;
            }
            else if(level.equals("INFO")){
                infoCount++;
            }
            else{
                logger.info("Unknown log level: " + level);
            }
        }
    }

    public int getErrorCount() {
        return errorCount;
    }
    public int getWarningCount() {
        return warningCount;
    }
    public int getInfoCount() {
        return infoCount;
    }

    public void printStats() {
        logger.info("Log Statistics:");
        logger.info("ERROR: " + errorCount);
        logger.info("WARNING: " + warningCount);
        logger.info("INFO: " + infoCount);
    }
}
