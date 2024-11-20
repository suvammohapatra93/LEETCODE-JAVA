
//LeetCode -> 2516 -> Take K of Each Chararcter from Left and Right

public class L2516 {

    public static int takeCharacters(String s, int k) {
        int[] count = new int[3];
        int n = s.length();

        // Count total occurrences of 'a', 'b', 'c'
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if we have enough characters
        for (int i = 0; i < 3; i++) {
            if (count[i] < k)
                return -1;
        }

        int[] window = new int[3];
        int left = 0, maxWindow = 0;

        // Find the longest window that leaves at least k of each character outside
        for (int right = 0; right < n; right++) {
            window[s.charAt(right) - 'a']++;

            // Shrink the window if it violates the condition
            while (left <= right &&
                    (count[0] - window[0] < k ||
                            count[1] - window[1] < k ||
                            count[2] - window[2] < k)) {
                window[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        // Result is the number of characters not in the largest valid window
        return n - maxWindow;
    }

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;

        int result = takeCharacters(s, k);

        System.out.println("Minimum time to take K characters: " + result);
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(1)