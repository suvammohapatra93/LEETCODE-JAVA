
// LEETCODE:162:FINE PEAK ELEMENT:

public class L162 {
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        // Binary search for the peak element
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is smaller than mid+1, peak is on the right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else { // Peak is on the left side or mid is the peak
                right = mid;
            }
        }

        // When left equals right, it is the peak element
        return left;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(findPeakElement(nums)); // Output should be 2 (index of peak element 3)
    }
}

// ! Time Complexity = O(log n)
// ! Space Complexity = O(1)