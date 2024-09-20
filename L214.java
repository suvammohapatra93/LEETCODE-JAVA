
// LEETCODE:214:SHORTEST PALINDROME:

public class L214 {
    public static String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = computeLPSArray(combined);

        // The longest palindrome prefix ends at index lps[lps.length - 1]
        int palLen = lps[lps.length - 1];

        return rev.substring(0, s.length() - palLen) + s;
    }

    private static int[] computeLPSArray(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s)); // Output: "aaacecaaa"

        s = "abcd";
        System.out.println(shortestPalindrome(s)); // Output: "dcbabcd"
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)