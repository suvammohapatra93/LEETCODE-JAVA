
//LEETCODE -> 1072 -> FLIP COLUMNS FOR MAXIMUM NUMBER OF EQUAL ROWS

import java.util.Arrays;

public class L1072 {

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int numCols = matrix[0].length;
        int maxIdenticalRows = 0;

        for (int[] currentRow : matrix) {
            // Create array to store flipped version of current row
            int[] flippedRow = new int[numCols];
            int identicalRowCount = 0;

            // Create flipped version of current row (0->1, 1->0)
            for (int col = 0; col < numCols; col++) {
                flippedRow[col] = 1 - currentRow[col];
            }

            // Check every row against current row and its flipped version
            for (int[] compareRow : matrix) {
                // If row matches either original or flipped pattern, increment counter
                if (Arrays.equals(compareRow, currentRow) ||
                        Arrays.equals(compareRow, flippedRow)) {
                    identicalRowCount++;
                }
            }

            maxIdenticalRows = Math.max(maxIdenticalRows, identicalRowCount);
        }

        return maxIdenticalRows;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1 },
                { 1, 0 },
                { 1, 1 }
        };

        System.out.println("Maximum Equal Rows After Flips: " + maxEqualRowsAfterFlips(matrix));
    }
}
