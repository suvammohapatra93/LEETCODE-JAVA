
//LeetCode -> 2044 -> Count Number of Maximum bitwise -OR Subsets

public class L2044 {
    int maxOrValue = 0; // Instance variable to store the maximum OR value
    int count = 0; // Instance variable to count the subsets with max OR

    public int countMaxOrSubsets(int[] nums) {
        // Calculate the maximum possible OR value
        for (int num : nums) {
            maxOrValue |= num;
        }

        // Start backtracking from index 0, with initial OR value as 0
        backtrack(nums, 0, 0);

        return count;
    }

    private void backtrack(int[] nums, int index, int currentOrValue) {
        // If we have considered all elements
        if (index == nums.length) {
            // Check if the current OR value matches the maximum OR value
            if (currentOrValue == maxOrValue) {
                count++;
            }
            return;
        }

        // Exclude the current number
        backtrack(nums, index + 1, currentOrValue);

        // Include the current number and compute the new OR value
        backtrack(nums, index + 1, currentOrValue | nums[index]);
    }

    public static void main(String[] args) {
        L2044 solution = new L2044();
        int[] nums = { 3, 1, 5, 6 };
        System.out.println(solution.countMaxOrSubsets(nums));
        // Output will be -> 9
    }
}

// ! Time Complexity = O(2^n)
// ! Space Complexity = O(n)