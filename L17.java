
// LEETCODE:17:LETTER COMBINATION OF A PHONE NUMBER:

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class L17 {
    private static final Map<Character, String> PHONE_MAP = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Edge case: if the input is empty, return an empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Start backtracking from an empty combination
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case: if the combination is complete, add it to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = PHONE_MAP.get(digits.charAt(index));

        // Loop through each letter and continue to backtrack
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Add the letter to the current combination
            backtrack(result, current, digits, index + 1); // Move to the next digit
            current.deleteCharAt(current.length() - 1); // Remove the last added letter (backtrack)
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> combinations = letterCombinations(digits);
        System.out.println("Letter combinations: " + combinations);

        // Output will be -> Letter combinations: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}

// ! Time Complexity = O(4^n)
// ! Space Complexity = O(n)
