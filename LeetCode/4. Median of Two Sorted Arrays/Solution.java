/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int len1 = nums1.length;
        int len2 = nums2.length;

        int left = 0;
        int right = len1;

        while(left <= right) {
            // Compute the mid from nums1
            int partitionX = left + (right - left)/2;
            // The partition of nums2 will be (len1 + len2 + 1) / 2 - partitionX; 
            // because partitionX + partitionY is (len1 + len2 + 1)/2
            int partitionY = (len1 + len2 + 1)/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == len1) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == len2) ? Integer.MAX_VALUE : nums2[partitionY];

            /**
             * Moment of Truth:
             * Check if maxLeftX <= minRightY and maxLeftY <= minRightX.
             * If so, compute the median and return
             */

             if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                 /**
                  * Check the length of the entire two arrays and decide based on odd or even length.
                  */
                  if((len1 + len2)%2 == 0)  // If it is even, return the average
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
                else
                    return ((double) Math.max(maxLeftX, maxLeftY));
             }
             else if (maxLeftX > minRightY) // Need to go left
                right = partitionX - 1;
            else
                left = partitionX + 1;

        }
        throw new IllegalArgumentException();
        
    }
}