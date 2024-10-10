
//LEETCODE -> 962 -> Maximum width ramp

public class L962 {

    public static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];

        // Fill rightMax array with the maximum values from the right
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int left = 0, right = 0;
        int maxWidth = 0;

        // Traverse the array using left and right pointers
        while (right < n) {
            // Move left pointer forward if current left exceeds rightMax
            while (left < right && nums[left] > rightMax[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, right - left);
            right++;
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 0, 8, 2, 1, 5 };
        int result = maxWidthRamp(nums);
        System.out.println("Maximum width ramp: " + result);
        // Output -> Maximum width ramp: 4
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)