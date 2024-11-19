
//LeetCode -> 2461 -> Maximum sum of distinct subarrays with length k

import java.util.HashMap;

public class L2461 {

    public static long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long currentSum = 0;
        int begin = 0;
        int end = 0;

        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        while (end < nums.length) {
            int currNum = nums[end];
            int lastOccurrence = numToIndex.getOrDefault(currNum, -1);

            // Adjust the window to maintain uniqueness or size constraint
            while (begin <= lastOccurrence || end - begin + 1 > k) {
                currentSum -= nums[begin];
                numToIndex.remove(nums[begin]);
                begin++;
            }

            numToIndex.put(currNum, end);
            currentSum += nums[end];

            // Check if the window size is exactly k
            if (end - begin + 1 == k) {
                ans = Math.max(ans, currentSum);
            }

            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;
        System.out.println("Maximum Subarray Sum with length " + k + ": " + maximumSubarraySum(nums, k));
        // output -> 15

        int[] nums2 = { 4, 4, 4 };
        k = 1;
        System.out.println("Maximum Subarray Sum with length " + k + ": " + maximumSubarraySum(nums2, k));
        // output -> 4

        int[] nums3 = { 1, 2, 3, 4, 5 };
        k = 2;
        System.out.println("Maximum Subarray Sum with length " + k + ": " + maximumSubarraySum(nums3, k));
        // output -> 9
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(K)