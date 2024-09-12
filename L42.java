
/*LEETCODE:42:TRAPPING RAIN WATER: 
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

public class L42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0; // Pointer to the left end of the array
        int right = height.length - 1; // Pointer to the right end of the array
        int leftMax = 0; // Track maximum height from the left
        int rightMax = 0; // Track maximum height from the right
        int waterTrapped = 0; // Total water trapped

        // Move the two pointers towards each other
        while (left < right) {
            // Process the left pointer if the left height is smaller
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update leftMax
                } else {
                    waterTrapped += leftMax - height[left]; // Calculate trapped water
                }
                left++; // Move left pointer
            }
            // Process the right pointer if the right height is smaller or equal
            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update rightMax
                } else {
                    waterTrapped += rightMax - height[right]; // Calculate trapped water
                }
                right--; // Move right pointer
            }
        }

        return waterTrapped; // Return the total water trapped
    }

    // Main method for testing
    public static void main(String[] args) {
        L42 sol = new L42();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(sol.trap(height)); // Output: 6
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)
