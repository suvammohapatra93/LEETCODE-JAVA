
// LEETCODE:1318:MINIMUM FLIPS TO MAKE a or b EQUAL TO c

public class L1318 {
    public static int minFlips(int a, int b, int c) {
        int flips = 0;

        // Iterate through all the bits up to 32-bit integer.
        for (int i = 0; i < 32; i++) {
            // Get the current bit of a, b, and c using bitwise AND with (1 << i)
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            // If bitC is 1, either bitA or bitB should be 1
            if (bitC == 1) {
                if (bitA == 0 && bitB == 0) {
                    flips += 1; // If both are 0, we need to flip one of them to 1
                }
            } else {
                // If bitC is 0, both bitA and bitB should be 0
                flips += bitA + bitB; // Count flips needed to make both 0
            }
        }

        return flips;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(2, 6, 5));
        // Output: 3
    }
}

// ! Time Complexity = O(1)
// ! Space Complexity = O(1)