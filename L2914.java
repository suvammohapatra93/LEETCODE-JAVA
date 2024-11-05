
//LeetCode -> 2914 -> Minimum Number of Changes To make Binary String Beautiful

public class L2914 {
    public static int minChanges(String s) {
        int minChangesRequired = 0;

        // Check pairs of characters (i, i+1) with step size 2
        for (int i = 0; i < s.length() - 1; i += 2) {
            // If characters in current pair don't match,
            // we need one change to make them equal
            if (s.charAt(i) != s.charAt(i + 1)) {
                minChangesRequired++;
            }
        }

        return minChangesRequired;
    }

    public static void main(String[] args) {
        String testString = "aabbcc"; // Replace with any test case as needed
        int result = minChanges(testString);
        System.out.println("Minimum changes required: " + result);
        // Outrput -> 0
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(1)