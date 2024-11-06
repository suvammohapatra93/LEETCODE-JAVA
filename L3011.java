
//LeetCode -> 3011 -> Find If Array Can Be Sorted

import java.util.Arrays;

public class L3011 {
    public static boolean canSortArray(int[] nums) {
        int n = nums.length;

        // Copy the original array to values
        int[] values = Arrays.copyOf(nums, n);

        // First Pass: Iterate from left to right
        // Goal: Move the maximum value of each segment as far right as possible
        for (int i = 0; i < n - 1; i++) {
            if (values[i] <= values[i + 1]) {
                continue;
            } else {
                // Count the number of set bits using Integer.bitCount
                if (Integer.bitCount(values[i]) == Integer.bitCount(values[i + 1])) {
                    // Swap them if they have the same number of set bits
                    int temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                } else {
                    return false; // Return false if they cannot be swapped
                }
            }
        }

        // Second Pass: Iterate from right to left
        // Goal: Move the minimum value of each segment as far left as possible
        for (int i = n - 1; i >= 1; i--) {
            if (values[i] >= values[i - 1]) {
                continue;
            } else {
                // Count the number of set bits using Integer.bitCount
                if (Integer.bitCount(values[i]) == Integer.bitCount(values[i - 1])) {
                    // Swap them if they have the same number of set bits
                    int temp = values[i];
                    values[i] = values[i - 1];
                    values[i - 1] = temp;
                } else {
                    return false; // Return false if they cannot be swapped
                }
            }
        }

        // If both passes complete without returning false, the array can be sorted
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 5, 7, 15 };
        System.out.println("Can the array be sorted? " + canSortArray(nums1));
        // Output -> true

        int[] nums2 = { 1, 2, 4, 8 };
        System.out.println("Can the array be sorted? " + canSortArray(nums2));
        // Output -> true

        int[] nums3 = { 7, 3, 5, 15 };
        System.out.println("Can the array be sorted? " + canSortArray(nums3));
        // Output -> false
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(N)