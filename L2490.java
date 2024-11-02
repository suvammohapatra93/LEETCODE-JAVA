
//LeetCode -> 2490 -> Circular Sentence

public class L2490 {

    public static boolean isCircularSentence(String sentence) {
        // Ensure sentence has more than one character
        if (sentence == null || sentence.isEmpty())
            return false;

        // Check if the first and last characters of the sentence are the same
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1))
            return false;

        // Traverse the sentence to check the circular word condition
        for (int i = 1; i < sentence.length() - 1; ++i) {
            // Look for spaces to identify word boundaries
            if (sentence.charAt(i) == ' ') {
                // Check if the last character of the previous word matches the first of the
                // next word
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }

        // If no discrepancies were found, the sentence is circular
        return true;
    }

    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        System.out.println(isCircularSentence(sentence));
        // Output should be true
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)