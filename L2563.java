
//LeetCode -> 2563 -> Count the number of fair pairs

import java.util.Arrays;

public class L2563 {

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lower_bound(nums, upper + 1) - lower_bound(nums, lower);
    }

    // Calculate the number of pairs with sum less than `value`.
    private static long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long result = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            // If sum is less than value, add the size of window to result and move to the
            // next index.
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                // Otherwise, shift the right pointer backwards, until we get a valid window.
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 2, 3 };
        int lower = 3;
        int upper = 6;

        long result = countFairPairs(nums, lower, upper);
        System.out.println("Number of fair pairs: " + result);
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(1)