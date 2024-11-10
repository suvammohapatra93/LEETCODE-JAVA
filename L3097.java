
//  LeetCode -> 3097 -> Shortest subarray with OR Atleast k ||

public class L3097 {
    public static int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowEnd = 0;
        int[] bitCounts = new int[32]; // Tracks count of set bits at each position

        // Expand window until end of array
        while (windowEnd < nums.length) {
            // Add current number to window
            updateBitCounts(bitCounts, nums[windowEnd], 1);

            // Contract window while OR value is valid
            while (windowStart <= windowEnd && convertBitCountsToNumber(bitCounts) >= k) {
                // Update minimum length found so far
                minLength = Math.min(minLength, windowEnd - windowStart + 1);

                // Remove leftmost number and shrink window
                updateBitCounts(bitCounts, nums[windowStart], -1);
                windowStart++;
            }

            windowEnd++;
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    // Updates bit count array when adding/removing a number from window
    private static void updateBitCounts(int[] bitCounts, int number, int delta) {
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            // Check if bit is set at current position
            if (((number >> bitPosition) & 1) != 0) {
                bitCounts[bitPosition] += delta;
            }
        }
    }

    // Converts bit count array back to number using OR operation
    private static int convertBitCountsToNumber(int[] bitCounts) {
        int result = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (bitCounts[bitPosition] != 0) {
                result |= 1 << bitPosition;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 7;

        int result = minimumSubarrayLength(nums, k);
        System.out.println("Minimum subarray length with OR at least " + k + " is: " + result);
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)