import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * If multiple answers are possible, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 *
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 *
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 *
 * Example 4:
 *
 * Input: numerator = 4, denominator = 333
 * Output: "0.(012)"
 *
 * Example 5:
 *
 * Input: numerator = 1, denominator = 5
 * Output: "0.2"
 *
 *
 *
 * Constraints:
 *
 *     -231 <= numerator, denominator <= 231 - 1
 *     denominator != 0
 */

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        
        String sign = ((numerator > 0) ^ (denominator > 0)) ? "-" : "";
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        return sign + (num / den) + computeDecimal(num % den, den);
    }
    
    private String computeDecimal(long numerator, long denominator) {
        if(numerator == 0)
            return "";
        
        StringBuilder result = new StringBuilder();
        result.append(".");
        
        Map<Long, Integer> numberIndex = new HashMap<>();
        numberIndex.put(numerator, result.length());
        
        while (numerator != 0) {
            numerator *= 10;
            result.append(numerator / denominator);
            numerator %= denominator;
            
            // If the same numerator is observed before
            // Add the brackets to index where that numerator was observed
            if (numberIndex.containsKey(numerator)) {
                int index = numberIndex.get(numerator);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            
            numberIndex.put(numerator, result.length());
        }
        return result.toString();
    }
}