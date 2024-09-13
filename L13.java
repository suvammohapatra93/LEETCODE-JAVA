
/*LEETCODE:13:ROMAN TO INTEGER: */

import java.util.HashMap;
import java.util.Map;

public class L13 {
    public static int romanToInt(String s) {
        // Step 1: Create a map to store the Roman numerals and their values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int n = s.length();

        // Step 2: Traverse the string
        for (int i = 0; i < n; i++) {
            int currentVal = romanMap.get(s.charAt(i));

            // If this is not the last character and the next Roman numeral is greater
            if (i < n - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
                // Subtract the current value
                total -= currentVal;
            } else {
                // Add the current value
                total += currentVal;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        String romanNumeral = "MCMXCIV";
        
        int result = romanToInt(romanNumeral);
        
        System.out.println(result); //Output should be 1994
    }    
}

//! Time Complexity = O(n)
//! Space Complexity = O(1)
