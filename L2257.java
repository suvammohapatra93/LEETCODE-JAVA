
//LeetCode -> 2257 -> Count unguarded cells in the grid

public class L2257 {

    private static void dfs(int row, int col, int[][] grid, char direction) {
        if (row < 0 ||
                row >= grid.length ||
                col < 0 ||
                col >= grid[0].length ||
                grid[row][col] == 2 || // Guard
                grid[row][col] == 3 || // Wall
                grid[row][col] == 1 // Already guarded
        ) {
            return;
        }
        grid[row][col] = 1; // Mark cell as guarded
        if (direction == 'U')
            dfs(row - 1, col, grid, 'U'); // Up
        if (direction == 'D')
            dfs(row + 1, col, grid, 'D'); // Down
        if (direction == 'L')
            dfs(row, col - 1, grid, 'L'); // Left
        if (direction == 'R')
            dfs(row, col + 1, grid, 'R'); // Right
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark guards' positions
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        // Mark walls' positions
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }

        // Mark cells as guarded by traversing from each guard
        for (int[] guard : guards) {
            dfs(guard[0] - 1, guard[1], grid, 'U'); // Up
            dfs(guard[0] + 1, guard[1], grid, 'D'); // Down
            dfs(guard[0], guard[1] - 1, grid, 'L'); // Left
            dfs(guard[0], guard[1] + 1, grid, 'R'); // Right
        }

        // Count unguarded cells
        int count = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        L2257 solution = new L2257();

        // Test case 1
        int m1 = 4, n1 = 6;
        int[][] guards1 = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
        int[][] walls1 = { { 0, 1 }, { 2, 2 }, { 1, 4 } };
        System.out.println("Unguarded cells: " + solution.countUnguarded(m1, n1, guards1, walls1)); // Expected: 7

        // Test case 2
        int m2 = 3, n2 = 3;
        int[][] guards2 = { { 1, 1 } };
        int[][] walls2 = { { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 } };
        System.out.println("Unguarded cells: " + solution.countUnguarded(m2, n2, guards2, walls2)); // Expected: 4
    }
}

// ! Time Complexity = O(m.n+(g.max(m,n)))
// ! Space Complexity = O(m.n)
