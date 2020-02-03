/**
 * Given a string of numbers and operators, 
 * return all possible results from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * 
 * Example 1:
 * Input: "2-1-1"
 * Output: [0, 2]
 * 
 * Explanation: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * Example 2:
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 */

class Solution {
    // Adding a map to prevent redundant calculation
    Map<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input))
            return map.get(input);
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*')
            {
                String partA = input.substring(0, i);
                String partB = input.substring(i+1);
                
                List<Integer> resultPartA = diffWaysToCompute(partA);   
                List<Integer> resultPartB = diffWaysToCompute(partB);
                
                for(Integer p1 : resultPartA)
                {
                    for(Integer p2 : resultPartB)
                    {
                        int temp = 0;
                        switch(input.charAt(i)) 
                        {
                            case '+':
                                temp = p1 + p2;
                                break;
                            case '-':
                                temp = p1 - p2;
                                break;
                            case '*':
                                temp = p1 * p2;
                                break;
                        }
                    result.add(temp);
                    }
                }
            }
        }
        if(result.size() == 0)
            result.add(Integer.valueOf(input));
        
        map.put(input, result);
        
        return result;
    }
}