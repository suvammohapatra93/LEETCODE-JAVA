/*LEETCODE-55 -JUMP GAME ->
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
*/


public class L55 {
    public static boolean canJump(int[] nums) {
        int maxReach = 0; // Initialize the furthest index we can reach
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If the current index is beyond the max reach, we can't move further
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update max reach
            
            // If we can reach or surpass the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}

//! Time Complexity = O(n)
//! Space Complexity = O(1)
