
//LeetCode -> 1277 -> Count square submatrices with all ones

public class L1277 {
    public static int countSquares(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = Math.min(
                            Math.min(dp[i][j + 1], dp[i + 1][j]),
                            dp[i][j]) + 1;
                    ans += dp[i + 1][j + 1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };
        int result = countSquares(matrix);
        System.out.println("Total square submatrices: " + result);
        // Output -> Total square submatrices: 15
    }
}

// ! Time Complexity = O(m * n)
// ! Space Complexity = O(m * n)