/**
 * You have an array of logs.  Each log is a space delimited string of words.
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * 
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * 
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * 
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 * Return the final order of the logs.
 * 
 * Example 1:
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 
 * Constraints:
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            int idx1 = s1.indexOf(' ');
            int idx2 = s2.indexOf(' ');
            
            String l1 = s1.substring(idx1 + 1);
            String l2 = s2.substring(idx2 + 1);
            
            if (l1.charAt(0) <= '9')
            {
                if (l2.charAt(0) <= '9') 
                    return 0;
                else 
                    return 1;
            } 
            else {
                if (l2.charAt(0) <= '9') 
                    return -1;
                else {
                        int cmpContent = l1.compareTo(l2);
                        
                        if (cmpContent != 0) 
                            return cmpContent;
                        
                        return s1.substring(0, idx1).compareTo(s2.substring(0, idx2));
                    }
                }
        });
        return logs;
    }
}