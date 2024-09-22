
// LEETCODE:440:KTH SMALLEST IN LEXICOGRAPHICAL ORDER:

public class L440 {
    public static int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);
            if (step <= k) {
                curr++;
                k -= step;
            } else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private static int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        int n = 13;
        int k = 2;
        System.out.println("The " + k + "-th smallest number in lexicographical order is: " + findKthNumber(n, k));

        // Output will be -> The 2-th smallest number in lexicographical order is: 10
    }
}

// ! Time Complexity = O(log n)
// ! Space Complexity = O(1)