
//LeetCode -> 1829 -> Maximum XOR for each query

public class L1829 {
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int xorProduct = 0;

        // Compute the cumulative XOR of all elements in nums
        for (int i = 0; i < nums.length; i++) {
            xorProduct ^= nums[i];
        }

        // Result array to store maximum XOR for each query
        int[] ans = new int[nums.length];

        // Mask with maximumBit number of 1s (e.g., if maximumBit = 3, mask = 0b111)
        int mask = (1 << maximumBit) - 1;

        // Calculate the maximum XOR for each query in reverse order
        for (int i = 0; i < nums.length; i++) {
            ans[i] = xorProduct ^ mask; // XOR with mask to get the max value
            xorProduct ^= nums[nums.length - 1 - i]; // Remove the last element in sequence
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 3 };
        int maximumBit = 2;

        int[] result = getMaximumXor(nums, maximumBit);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(N)