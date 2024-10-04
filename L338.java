
//LEETCODE:338:COUNTING BITS:

public class L338 {
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] result = countBits(n);
        for (int count : result) {
            System.out.print(count + " ");
        }
        // Output will be -> 0 1 1 2 1 2
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)