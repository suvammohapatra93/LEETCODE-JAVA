
// LEETCODE:6:ZIGZAG CONVERSION:

public class L6 {
    public static String convert(String s, int numRows) {
        // Edge case: if numRows is 1, the string doesn't need conversion
        if (numRows == 1) {
            return s;
        }

        // Step 1: Create a StringBuilder array to represent rows
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Step 2: Traverse the string and append characters to the correct row
        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction when you reach the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Step 3: Join all rows together
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        L6 solution = new L6();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(solution.convert(s, numRows)); 
        // Output: "PAHNAPLSIIGYIR"
    }
}
