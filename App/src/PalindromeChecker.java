import java.util.Scanner;

public class PalindromeChecker {

    // UC9: Recursive palindrome check
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;                 // Base condition
        if (str.charAt(start) != str.charAt(end)) return false; // Mismatch
        return isPalindrome(str, start + 1, end - 1); // Recurse
    }

    // UC10: Normalize string (ignore case & spaces)
    public static String normalizeString(String input) {
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        // Normalize string for UC10
        String normalized = normalizeString(input);

        // Check palindrome using recursion (UC9)
        boolean result = isPalindrome(normalized, 0, normalized.length() - 1);

        // Output result
        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome");
        }

        scanner.close();
    }
}