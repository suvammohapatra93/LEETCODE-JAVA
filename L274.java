/*LEETCODE:274:H-INDEX ------------>
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
Example 1:
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:
Input: citations = [1,3,1]
Output: 1
Constraints:
n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000
 */

import java.util.Arrays;

public class L274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        // Iterate through the sorted citations array to find the H-Index
        for (int i = 0; i < n; i++) {
            int h = n - i; // Number of papers with at least citations[i] citations
            if (citations[i] >= h) {
                return h; // Found the H-Index
            }
        }

        // If no valid H-Index found, return 0
        return 0;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        L274 solution = new L274();

        // Example 1:
        int[] citations1 = { 3, 0, 6, 1, 5 };
        int result1 = solution.hIndex(citations1);
        System.out.println("H-Index for Example 1: " + result1);
        // Expected output: 3

        // Example 2:
        int[] citations2 = { 10, 8, 5, 4, 3 };
        int result2 = solution.hIndex(citations2);
        System.out.println("H-Index for Example 2: " + result2);
        // Expected output: 4

        // Example 3:
        int[] citations3 = { 25, 8, 5, 3, 3 };
        int result3 = solution.hIndex(citations3);
        System.out.println("H-Index for Example 3: " + result3);
        // Expected output: 3

        // Example 4:
        int[] citations4 = { 1, 1, 1, 1, 1 };
        int result4 = solution.hIndex(citations4);
        System.out.println("H-Index for Example 4: " + result4);
        // Expected output: 1
    }
}

// Time Complexity = O(N log N)
// Space Complexity = O(1)
