import java.util.*;

/**
 * @author kalpak
 *
 * Design a logger system that receive stream of messages along with its timestamps,
 * each message should be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 *
 * Example:
 *
 * Logger logger = new Logger();
 *
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 *
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 *
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 *
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 *
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 *
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 */

public class LoggerRateLimiter {
    private static final int WINDOW = 10;
    private Queue<Record> messageQueue;
    private Set<String> lookup;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        messageQueue = new LinkedList<>();
        lookup = new HashSet<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!messageQueue.isEmpty() && timestamp - messageQueue.peek().timestamp >= WINDOW) {
            Record record = messageQueue.poll();
            lookup.remove(record.msg);
        }

        if(lookup.contains(message))
            return false;

        // Iterate over the queue
         Iterator<Record> itr = messageQueue.iterator();

         while(itr.hasNext()) {
             Record temp = itr.next();
             if(temp.msg.equals(message))
                 return false;
         }

        messageQueue.offer(new Record(timestamp, message));
        lookup.add(message);
        return true;
    }

    private static class Record {
        int timestamp;
        String msg;

        public Record(int timestamp, String msg) {
            this.timestamp = timestamp;
            this.msg = msg;
        }
    }
}
