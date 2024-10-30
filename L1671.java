
// LeetCode -> 1671 -> Minimum Number of Removals to make mountain array

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L1671 {

    // Helper method to calculate the Longest Increasing Subsequence (LIS) lengths
    // up to each index
    private List<Integer> getLongestIncreasingSubsequenceLength(List<Integer> v) {
        List<Integer> lisLen = new ArrayList<>(Collections.nCopies(v.size(), 1));
        List<Integer> lis = new ArrayList<>();
        lis.add(v.get(0));

        for (int i = 1; i < v.size(); i++) {
            int index = lowerBound(lis, v.get(i));

            // Add to the list if v[i] is greater than the last element
            if (index == lis.size()) {
                lis.add(v.get(i));
            } else {
                // Replace the element at index with v[i]
                lis.set(index, v.get(i));
            }

            lisLen.set(i, lis.size());
        }

        return lisLen;
    }

    // Returns the index of the first element which is equal to or greater than
    // target.
    private int lowerBound(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Main function to calculate the minimum number of removals to make mountain
    // array
    public int minimumMountainRemovals(int[] nums) {
        int N = nums.length;
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums)
            numsList.add(num);

        List<Integer> lisLength = getLongestIncreasingSubsequenceLength(numsList);

        Collections.reverse(numsList);
        List<Integer> ldsLength = getLongestIncreasingSubsequenceLength(numsList);
        // Reverse the length array to correctly depict the length of longest decreasing
        // subsequence for each index
        Collections.reverse(ldsLength);

        int minRemovals = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (lisLength.get(i) > 1 && ldsLength.get(i) > 1) {
                minRemovals = Math.min(minRemovals, N - lisLength.get(i) - ldsLength.get(i) + 1);
            }
        }

        return minRemovals;
    }

    public static void main(String[] args) {
        L1671 solution = new L1671();
        int[] nums = { 2, 1, 1, 5, 6, 2, 3, 1 }; // Example input
        int result = solution.minimumMountainRemovals(nums);
        System.out.println("Minimum removals to make mountain array: " + result);
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(n)