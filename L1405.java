
//LeetCode -> 1405 -> Longest Happy String ->

public class L1405 {

    public static String longestDiverseString(int a, int b, int c) {
        int curra = 0, currb = 0, currc = 0;
        int totalIterations = a + b + c;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < totalIterations; i++) {
            if ((a >= b && a >= c && curra != 2) || (a > 0 && (currb == 2 || currc == 2))) {
                ans.append('a');
                a--;
                curra++;
                currb = 0;
                currc = 0;
            } else if ((b >= a && b >= c && currb != 2) || (b > 0 && (currc == 2 || curra == 2))) {
                ans.append('b');
                b--;
                currb++;
                curra = 0;
                currc = 0;
            } else if ((c >= a && c >= b && currc != 2) || (c > 0 && (curra == 2 || currb == 2))) {
                ans.append('c');
                c--;
                currc++;
                curra = 0;
                currb = 0;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int a = 1, b = 1, c = 7;
        String result = longestDiverseString(a, b, c);
        System.out.println("The longest diverse string is: " + result);

        System.out.println(longestDiverseString(2, 2, 1));
        // Output will be -> The longest diverse string is: ccaccbcc /ababc
    }
}

// ! Time Complexity = O(a+b+c)
// ! Space Complexity = O(a+b+c)