/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
 * 
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * Example:
 * n = 15,
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * 
 */

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for(int i = 1, fizz = 0, buzz = 0; i <= n; i++)
        {
            fizz++;
            buzz++;
            
            if(fizz == 3 && buzz == 5)
            {
                result.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            }
            else if(fizz == 3)
            {
                result.add("Fizz");
                fizz = 0;
            }
            else if(buzz == 5)
            {
                result.add("Buzz");
                buzz = 0;
            }
            else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
