
//LeetCode -> 862 -> Shortest subarray with sum at least k

import java.util.ArrayDeque;
import java.util.Deque;

public class L862 {

    public static int shortestSubarray(int[] nums, int targetSum) {
        int n = nums.length;

        // Size is n+1 to handle subarrays starting from index 0
        long[] prefixSums = new long[n + 1];

        // Calculate prefix sums
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        Deque<Integer> candidateIndices = new ArrayDeque<>();

        int shortestSubarrayLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // Remove candidates from front of deque where subarray sum meets target
            while (!candidateIndices.isEmpty() &&
                    prefixSums[i] - prefixSums[candidateIndices.peekFirst()] >= targetSum) {
                // Update shortest subarray length
                shortestSubarrayLength = Math.min(
                        shortestSubarrayLength,
                        i - candidateIndices.pollFirst());
            }

            // Maintain monotonicity by removing indices with larger prefix sums
            while (!candidateIndices.isEmpty() &&
                    prefixSums[i] <= prefixSums[candidateIndices.peekLast()]) {
                candidateIndices.pollLast();
            }

            // Add current index to candidates
            candidateIndices.offerLast(i);
        }

        // Return -1 if no valid subarray found
        return shortestSubarrayLength == Integer.MAX_VALUE ? -1 : shortestSubarrayLength;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = { 2, -1, 2 };
        int targetSum1 = 3;
        System.out.println("Shortest subarray length: " + shortestSubarray(nums1, targetSum1));
        // Expected output: 3

        // Test case 2
        int[] nums2 = { 1 };
        int targetSum2 = 1;
        System.out.println("Shortest subarray length: " + shortestSubarray(nums2, targetSum2));
        // Expected output: 1

        // Test case 3
        int[] nums3 = { 1, 2 };
        int targetSum3 = 4;
        System.out.println("Shortest subarray length: " + shortestSubarray(nums3, targetSum3));
        // Expected output: -1

        // Test case 4
        int[] nums4 = { 84, -37, 32, 40, 95 };
        int targetSum4 = 167;
        System.out.println("Shortest subarray length: " + shortestSubarray(nums4, targetSum4));
        // Expected output: 3
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(N)