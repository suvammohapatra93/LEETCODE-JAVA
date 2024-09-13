
/*LEETODE:2542:MAXIMUM SUBSEQUENCE STORE: */

import java.util.*;

public class L2542 {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // Create a list of pairs (nums1[i], nums2[i])
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        // Sort pairs by nums2 values in decreasing order
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        // Min-heap to keep track of the top k largest elements from nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;

        // Iterate through the sorted pairs
        for (int i = 0; i < n; i++) {
            int num1 = pairs[i][0];
            int num2 = pairs[i][1];

            // Add the current nums1[i] to the min-heap and sum
            minHeap.add(num1);
            sum += num1;

            // If the heap exceeds size k, remove the smallest element
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // If we have exactly k elements, calculate the score
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * num2);
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 3, 2 };
        int[] nums2 = { 2, 1, 3, 4 };
        int k = 3;

        long result = maxScore(nums1, nums2, k);

        
        System.out.println(result);  //Output should be 12
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(n)