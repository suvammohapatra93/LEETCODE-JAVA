
//LeetCode -> 1545 -> Find Kth Bit in Nth Binary String ->

public class L1545 {
    public static char findKthBit(int n, int k) {
        return findKthBitHelper(n, k);
    }

    private static char findKthBitHelper(int n, int k) {
        // Base case: If n is 1, the string S_1 is "0"
        if (n == 1)
            return '0';

        // Find the length of the string S_n, which is 2^n - 1
        int length = (1 << n) - 1; // Equivalent to 2^n - 1

        // Middle bit is always 1
        int mid = (length / 2) + 1;

        if (k == mid) {
            // If k is the middle bit, it's always '1'
            return '1';
        } else if (k < mid) {
            // If k is in the first half, it's identical to the same position in S_{n-1}
            return findKthBitHelper(n - 1, k);
        } else {
            // If k is in the second half, map it to the reverse and flipped position
            int mirroredK = length - k + 1;
            return invert(findKthBitHelper(n - 1, mirroredK));
        }
    }

    private static char invert(char bit) {
        return bit == '0' ? '1' : '0';
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1)); // Output: '0'
        System.out.println(findKthBit(4, 11)); // Output: '1'
        System.out.println(findKthBit(2, 3)); // Output: '1'
        System.out.println(findKthBit(5, 12)); // Output: '0'
    }
}

// ! Time Ciomplexity = O(n)
// ! Space Ciomplexity = O(n)