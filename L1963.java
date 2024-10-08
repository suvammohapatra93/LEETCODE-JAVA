
// LEETCODE:1963->

public class L1963 {
    public static int minSwaps(String s) {
        int stackSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If character is opening bracket, increment the stack size.
            if (ch == '[')
                stackSize++;
            else {
                // If the character is closing bracket, and we have an opening bracket, decrease
                // the stack size.
                if (stackSize > 0)
                    stackSize--;
            }
        }
        return (stackSize + 1) / 2;
    }

    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println("Minimum swaps needed: " + minSwaps(s));
        // Output will be -> Minimum swaps needed: 2
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)