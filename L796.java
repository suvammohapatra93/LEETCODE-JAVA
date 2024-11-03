
//LeetCode -> 796 -> Rotate String

public class L796 {

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s, goal));
        // Output -> true
    }
}

// ! Time Complexity -> O(n)
// ! Space Complexity -> O(n)