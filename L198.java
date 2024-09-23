
// LEETCODE:198:HOUSE ROBBER:

public class L198 {
    public static int rob(int[] nums) {
        int n = nums.length;

        // Base cases: if there's only one house, rob it
        if (n == 1)
            return nums[0];

        // Initialize two variables to store the maximum money up to the current house
        int prev2 = 0; // Money robbed up to two houses back
        int prev1 = nums[0]; // Money robbed up to the previous house

        // Iterate through the array of houses starting from the second house
        for (int i = 1; i < n; i++) {
            int current = Math.max(prev1, prev2 + nums[i]); // Max of either robbing current or skipping it
            prev2 = prev1; // Move the window forward
            prev1 = current;
        }

        return prev1; // Return the maximum money that can be robbed up to the last house
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 }; // Example input
        System.out.println(rob(nums)); // Output: 12
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)