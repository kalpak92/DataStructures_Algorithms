/**
 * We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  
 * (The websites in a 3-sequence are not necessarily distinct.)
 * 
 * Find the 3-sequence visited by the largest number of users. 
 * If there is more than one solution, return the lexicographically smallest such 3-sequence.
 * 
 * Example 1:
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation: 
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * 
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 * 
 * Note:
 *     3 <= N = username.length = timestamp.length = website.length <= 50
 *     1 <= username[i].length <= 10
 *     0 <= timestamp[i] <= 10^9
 *     1 <= website[i].length <= 10
 *     Both username[i] and website[i] contain only lowercase characters.
 *     It is guaranteed that there is at least one user who visited at least 3 websites.
 *     No user visits two websites at the same time
 */

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> data = new HashMap<>();
        
        // collect the website info for every user, key: username, value: (timestamp, website)
        for(int i = 0; i < username.length; i++) {
            data.putIfAbsent(username[i], new ArrayList<>());
            data.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        
        // Map to record every 3 combination occuring time for the different user.
        Map<String, Integer> count = new HashMap<>();
        String result = "";
        for(String key : data.keySet()) {
            // Set to prevent duplicate visit of the 3 sequence
            Set<String> set = new HashSet<>();
            List<Pair> userData = data.get(key);
            
            //Sort the userData on the basis of time
            Collections.sort(userData, (a, b) -> (a.time - b.time));
            
            for (int i = 0; i < userData.size(); i++) {
                for (int j = i + 1; j < userData.size(); j++) {
                    for (int k = j + 1; k < userData.size(); k++) {
                        String temp = userData.get(i).website + " " + userData.get(j).website + " " + 
                                        userData.get(k).website;
                        
                        if (!set.contains(temp)) {
                            count.put(temp, count.getOrDefault(temp, 0) + 1);
                            set.add(temp);
                        }
                        
                        if (result.equals("") || count.get(result) < count.get(temp) || 
                                (count.get(result) == count.get(temp) && result.compareTo(temp) > 0)) {
                            // make sure of the right lexicographic  order
                            result = temp;
                        }
                    }
                }
            }
        }
            
        // get the correct answer
        String[] temp = result.split(" ");
        List<String> answer = new ArrayList<>();
        
        for (String str : temp)
            answer.add(str);
        
        return answer;
    }
}

class Pair {
    int time;
    String website;
    
    public Pair(int time, String website) {
        this.time = time;
        this.website = website;
    }
}