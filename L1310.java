
/* LEETCODE:1310:XOR QUERIES OF SUBARRAY: */

public class L1310 {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];

        // Compute the prefix XOR for the array
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }

        int[] result = new int[queries.length];

        // Answer each query using the prefix XOR array
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l == 0) {
                result[i] = prefixXor[r];
            } else {
                result[i] = prefixXor[r] ^ prefixXor[l - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 8 };
        int[][] queries = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } };

        int[] result = xorQueries(arr, queries);

        // Print the results
        for (int res : result) {
            System.out.println(res);
        } //Output should be 2 7 14 8
    }
}

// ! Time Complexity = O(n+q);
// ! Space Complexity = O(n);