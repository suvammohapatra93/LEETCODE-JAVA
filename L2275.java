
//LeetCode -> 2275 -> Largest Combination with Bitwise NAD greater than 0

public class L2275 {

    public static int largestCombination(int[] candidates) {
        int maxCount = 0; // Variable to track the maximum count of set bits.

        // Iterate through each of the 24 bits (since the maximum number in the array is
        // <= 10^7).
        for (int i = 0; i < 24; i++) {
            int count = 0; // Count of numbers with the i-th bit set.

            // Check each number in the candidates array.
            for (int num : candidates) {
                if ((num & (1 << i)) != 0) { // Check if the i-th bit is set.
                    count++; // If set, increment the count.
                }
            }

            // Update the maximum count if the current count is larger.
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] candidates = { 16, 17, 71, 62, 12, 24, 14 };
        int result = largestCombination(candidates);
        System.out.println("The largest combination is: " + result);
        // Output -> 4
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(1)