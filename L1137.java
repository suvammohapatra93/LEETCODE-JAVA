
// LEETCODE:1137:N-TH TRIBONACCI NUMBER:


public class L1137 {
    public static int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3; i <= n; i++) {
            int t3 = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }
        return t2;
    }

    public static void main(String[] args) {
        int n = 10; 
        System.out.println(tribonacci(n)); // Output: 149
    }
}