/**
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, 
 * all the versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. 
 * You should minimize the number of calls to the API.
 * 
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 * 
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * 
 * Then 4 is the first bad version. 
 */

/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while(left <= right) {
            int mid  = left + (right - left)/2;
            if(isBadVersion(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        /**
         * During the last iteration of loop mid == low == high, 
         * mid can either be good or bad version. 
         * if mid is good version (low = mid +1) we need to return mid +1 (i.e. low) as the first bad    version, 
         * if mid was bad version (high = mid -1) low was already pointing to first bad version. So we always return low.
         */
        return left;
    }
}