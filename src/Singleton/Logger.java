package Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

public class Logger {
    private static Logger instance;
    private String filename;
    private FileWriter logWriter;

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    public synchronized void setFilename(String filename) {
        if (Objects.equals(this.filename, filename)) return;

        this.closeWriter(); // close existing log writer if present
        this.filename = filename;

        if (this.filename == null) return;

        try {
            this.logWriter = new FileWriter(this.filename, true);
        } catch (IOException exception) {
            System.out.println("An error occurred while setting log file to " + this.filename);
            exception.printStackTrace();
            this.logWriter = null;
        }
    }

    public synchronized void info(String message) {
        this.log(LogLevel.INFO, message);
    }

    public synchronized void warning(String message) {
        this.log(LogLevel.WARNING, message);
    }

    public synchronized void error(String message) {
        this.log(LogLevel.ERROR, message);
    }

    public synchronized void debug(String message) {
        this.log(LogLevel.DEBUG, message);
    }

    private synchronized void log(LogLevel level, String message) {
        if (this.filename == null) return;

        LocalDateTime now = LocalDateTime.now();

        try {
            if (this.logWriter == null) {
                this.logWriter = new FileWriter(this.filename, true);
            }

            logWriter.write("[" + level.name() + "] " + now + ": " + message + "\n");
        } catch (IOException exception) {
            System.out.println("An error occurred while logging to " + this.filename);
            exception.printStackTrace();
        }
    }

    private synchronized void closeWriter() {
        if (this.logWriter == null) return;

        try {
            this.logWriter.close();
        } catch (IOException exception) {
            System.out.println("An error occurred while closing the log file " + this.filename);
            exception.printStackTrace();
        } finally {
            this.logWriter = null;
        }
    }

    public synchronized void close() {
        this.closeWriter();
        this.filename = null;
    }
}
