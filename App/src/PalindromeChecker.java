public class PalindromeChecker {

    // Public method – entry point for checking palindrome
    public boolean checkPalindrome(String input) {
        if (input == null) return false; // null check
        String normalized = normalizeString(input);   // UC10 logic
        return isPalindromeRecursive(normalized, 0, normalized.length() - 1); // UC9 logic
    }

    // Private helper – normalize string (ignore spaces and case)
    private String normalizeString(String input) {
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    // Private helper – recursive palindrome check
    private boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}