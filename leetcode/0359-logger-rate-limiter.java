import java.util.HashMap;

class Logger {
    HashMap<String, Integer> log;

    /** Initialize your data structure here. */
    public Logger() {
        log = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given   
        timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!log.containsKey(message)) {
            log.put(message, timestamp);
            return true;
        }

        Integer t = log.get(message);

        if (timestamp - t >= 10) {
            log.put(message, timestamp);
            return true;
        }
        return false;
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
