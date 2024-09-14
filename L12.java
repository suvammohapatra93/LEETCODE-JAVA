
// LEETCODE:12:INTEGER TO ROMAN:

public class L12 {
    public String intToRoman(int num) {
        // Define integer values and their corresponding Roman numeral representations
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder result = new StringBuilder();

        // Iterate through the values array
        for (int i = 0; i < values.length; i++) {
            // Append the Roman numeral while subtracting its value from num
            while (num >= values[i]) {
                num -= values[i];
                result.append(romanNumerals[i]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        L12 l12 = new L12();

        int num = 1994; // Expected output: "MCMXCIV"

        String roman = l12.intToRoman(num);

        System.out.println("The Roman numeral for " + num + " is: " + roman);
    }
}

// ! Time Complexity = O(1)
// ! Space Complexity = O(1)