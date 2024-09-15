
// LEETCODE:58:LENGTH OF LAST WORD:

public class L58 {
    public static int lengthOfLastWord(String s) {
        // Trim any trailing spaces from the string
        s = s.trim();

        // Initialize a counter for the length of the last word
        int length = 0;

        // Start from the end of the string and count the last word
        for (int i = s.length() - 1; i >= 0; i--) {
            // If a space is encountered, the last word has ended
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }

        return length; // Return the length of the last word
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "Hello World";
        System.out.println("Length of last word: " + lengthOfLastWord(test1)); // Expected output: 5

        String test2 = "   fly me   to   the moon  ";
        System.out.println("Length of last word: " + lengthOfLastWord(test2)); // Expected output: 4

        String test3 = "luffy is still joyboy";
        System.out.println("Length of last word: " + lengthOfLastWord(test3)); // Expected output: 6

        String test4 = "a";
        System.out.println("Length of last word: " + lengthOfLastWord(test4)); // Expected output: 1
    }
}

// ! Time Complexty = O(n)
// ! Space Complexty = O(1)
