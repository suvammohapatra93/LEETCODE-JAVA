
/*LEETCODE:2326:SPIRAL MATRIX |V: */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class L2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Initialize the m x n matrix with -1
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        // Initialize boundaries
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        // Pointer to traverse the linked list
        ListNode current = head;

        // Fill the matrix in spiral order
        while (top <= bottom && left <= right) {
            // Move from left to right across the top boundary
            for (int j = left; j <= right && current != null; j++) {
                matrix[top][j] = current.val;
                current = current.next;
            }
            top++; // Move the top boundary downwards

            // Move from top to bottom along the right boundary
            for (int i = top; i <= bottom && current != null; i++) {
                matrix[i][right] = current.val;
                current = current.next;
            }
            right--; // Move the right boundary leftwards

            // Move from right to left across the bottom boundary
            for (int j = right; j >= left && current != null; j--) {
                matrix[bottom][j] = current.val;
                current = current.next;
            }
            bottom--; // Move the bottom boundary upwards

            // Move from bottom to top along the left boundary
            for (int i = bottom; i >= top && current != null; i--) {
                matrix[i][left] = current.val;
                current = current.next;
            }
            left++; // Move the left boundary rightwards
        }

        // Return the filled matrix
        return matrix;
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        // Define the dimensions of the matrix
        int m = 3; // number of rows
        int n = 3; // number of columns

        // Create an instance of L2326
        L2326 solution = new L2326();

        // Call the spiralMatrix method
        int[][] result = solution.spiralMatrix(m, n, head);

        // Print the result matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// ! Time Complexity = O(m*n)
// ! Space Complexity = O(m*n)