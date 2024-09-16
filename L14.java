
// LEETCODE:14:LONGEST COMMON PREFIX:

public class L14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        // Take the first string as the initial prefix
        String prefix = strs[0];

        // Compare the prefix with the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix until it matches the start of the string
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, return an empty string
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        String result = longestCommonPrefix(strs);

        System.out.println("Longest Common Prefix: " + result);
        //Output will be -> Longest Common Prefix: fl
    }
}

// ! Time Complexity = O(n * m);
// ! Space Complexity = O(1)