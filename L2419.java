
/*LEETCODE:2419:LONGEST SUBARRAY WITH MAXIMUM BITWISE AND: */

public class L2419 {
    public static int longestSubarray(int[] nums) {
        // Step 1: Find the maximum element in the array
        int maxNum = 0;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }

        // Step 2: Find the longest subarray with the maximum element
        int longest = 0;
        int currentLength = 0;

        for (int num : nums) {
            if (num == maxNum) {
                currentLength++; // Extend the current subarray
            } else {
                // Compare with the longest and reset current length
                longest = Math.max(longest, currentLength);
                currentLength = 0;
            }
        }

        // After loop, check one last time in case the longest subarray is at the end
        longest = Math.max(longest, currentLength);

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3 };

        int result = L2419.longestSubarray(nums);

        System.out.println("The length of the longest subarray with the maximum element is: " + result);
        // Output will be -> The length of the longest subarray with the maximum element is: 3
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)