
/*LEETCODE:2220:MINIMUM BIT FLIPS TO CONVERT NUMBER: 
 * 
 * A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.
For example, for x = 7, the binary representation is 111 and we may choose any bit (including any leading zeros not shown) and flip it. We can flip the first bit from the right to get 110, flip the second bit from the right to get 101, flip the fifth bit from the right (a leading zero) to get 10111, etc.
Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
Example 1:
Input: start = 10, goal = 7
Output: 3
Explanation: The binary representation of 10 and 7 are 1010 and 0111 respectively. We can convert 10 to 7 in 3 steps:
- Flip the first bit from the right: 1010 -> 1011.
- Flip the third bit from the right: 1011 -> 1111.
- Flip the fourth bit from the right: 1111 -> 0111.
It can be shown we cannot convert 10 to 7 in less than 3 steps. Hence, we return 3.
Example 2:
Input: start = 3, goal = 4
Output: 3
Explanation: The binary representation of 3 and 4 are 011 and 100 respectively. We can convert 3 to 4 in 3 steps:
- Flip the first bit from the right: 011 -> 010.
- Flip the second bit from the right: 010 -> 000.
- Flip the third bit from the right: 000 -> 100.
It can be shown we cannot convert 3 to 4 in less than 3 steps. Hence, we return 3.
Constraints:
0 <= start, goal <= 109
*/

public class L2220 {
    public int minBitFlips(int start, int goal) {
        // Step 1: XOR the two numbers to get the differing bits
        int xor = start ^ goal;

        // Step 2: Count the number of 1s in the xor result
        int count = 0;
        while (xor > 0) {
            // If the least significant bit is 1, increment the count
            count += xor & 1;
            // Right shift xor to check the next bit
            xor >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        L2220 l2220 = new L2220();

        // Example 1: start = 10 (1010 in binary), goal = 7 (0111 in binary)
        int start1 = 10;
        int goal1 = 7;
        System.out.println("Minimum bit flips (Example 1): " + l2220.minBitFlips(start1, goal1));
        // Output: 3 (since 1010 to 0111 requires 3 flips)

        // Example 2: start = 0, goal = 15 (1111 in binary)
        int start2 = 0;
        int goal2 = 15;
        System.out.println("Minimum bit flips (Example 2): " + l2220.minBitFlips(start2, goal2));
        // Output: 4 (since 0000 to 1111 requires 4 flips)

        // Example 3: start = 29 (11101 in binary), goal = 15 (01111 in binary)
        int start3 = 29;
        int goal3 = 15;
        System.out.println("Minimum bit flips (Example 3): " + l2220.minBitFlips(start3, goal3));
        // Output: 2 (since 11101 to 01111 requires 2 flips)
    }
}


//! Time Complexity = O(1)
//! Space Complexity = O(1)