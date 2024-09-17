
// LEETCODE -> 151 ->

public class L151 {
    public static String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();

        // Split the string into words
        String[] words = s.split("\\s+");

        // Initialize a StringBuilder for the result
        StringBuilder reversed = new StringBuilder();

        // Reverse the order of words and construct the final string
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) { // Add a space if it's not the last word
                reversed.append(" ");
            }
        }

        // Convert StringBuilder to String and return
        return reversed.toString();
    }

    public static void main(String args[]) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        // Output should be -> blue is sky the
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)