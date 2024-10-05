
//LEETCODE 136:SINGLE NUMBER:

public class L136 {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println("The single number is: " + singleNumber(nums));
        // Output: 4
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)
