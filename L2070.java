
//LeetCode -> 2070 -> Most Beautiful item for each query

import java.util.Arrays;

public class L2070 {
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];

        // Sort items by price in ascending order
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Store queries with their original indices for result assignment
        int[][] queriesWithIndices = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndices[i][0] = queries[i];
            queriesWithIndices[i][1] = i;
        }

        // Sort queries by value to process in ascending order
        Arrays.sort(queriesWithIndices, (a, b) -> a[0] - b[0]);

        int itemIndex = 0; // Index for iterating over items array
        int maxBeauty = 0; // Track max beauty seen so far

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int query = queriesWithIndices[i][0];
            int originalIndex = queriesWithIndices[i][1];

            // Find the maximum beauty for items that cost <= current query price
            while (itemIndex < items.length && items[itemIndex][0] <= query) {
                maxBeauty = Math.max(maxBeauty, items[itemIndex][1]);
                itemIndex++;
            }

            // Store the result in the answer array at the original query index
            ans[originalIndex] = maxBeauty;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] items = { { 1, 2 }, { 2, 4 }, { 3, 6 } };
        int[] queries = { 1, 2, 3 };

        int[] results = maximumBeauty(items, queries);
        System.out.println(Arrays.toString(results));
        // Output: [2, 4, 6]
    }
}

// ! Time Complexity = O(m+n(log n))
// ! Space Complexity = O(m+n)