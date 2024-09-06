/*LEETCODE:45:JUMP GAME ||:
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */

public class L45 {
    public static int jump(int[] nums) {
        if (nums.length == 1)
            return 0; // If there's only one element, no jumps are needed

        int jumps = 0; // Number of jumps needed to reach the end
        int currentEnd = 0; // The farthest point that can be reached with the current number of jumps
        int farthest = 0; // The farthest point that can be reached in the next step

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point that can be reached
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the current range, we must jump
            if (i == currentEnd) {
                jumps++; // Increment the jump count
                currentEnd = farthest; // Update the current range to the farthest point

                // If the currentEnd reaches or exceeds the last index, we can stop
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        // Test case 1: Example case
        int[] nums1 = { 2, 3, 1, 1, 4 };
        System.out.println("Minimum jumps for nums1: " + jump(nums1)); 
        // Output should be 2

        // Test case 2: Single element array
        int[] nums2 = { 0 };
        System.out.println("Minimum jumps for nums2: " + jump(nums2)); 
        // Output should be 0

        // Test case 3: Already at the last element
        int[] nums3 = { 1 };
        System.out.println("Minimum jumps for nums3: " + jump(nums3)); 
        // Output should be 0

        // Test case 4: Large jumps at the start
        int[] nums4 = { 4, 1, 1, 3, 1, 1, 1 };
        System.out.println("Minimum jumps for nums4: " + jump(nums4)); 
        // Output should be 2

        // Test case 5: Cannot reach the end (although this is not a valid input as per
        // the problem statement)
        int[] nums5 = { 3, 2, 1, 0, 4 };
        System.out.println("Minimum jumps for nums5: " + jump(nums5));
        // Output will depend on the method logic (e.g., might not handle such cases)

    }

}

// Time Complexity = O(n)
// Space Complexity = O(1)
