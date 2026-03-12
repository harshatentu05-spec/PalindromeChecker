import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.Scanner;

public class PalindromeChecker {

    // Stack-based palindrome check
    private static boolean checkWithStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }

    // Deque-based palindrome check
    private static boolean checkWithDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }

    // Recursive palindrome check
    private static boolean checkWithRecursion(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkWithRecursion(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        // Normalize string
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Stack strategy
        long startStack = System.nanoTime();
        boolean resultStack = checkWithStack(normalized);
        long endStack = System.nanoTime();

        // Deque strategy
        long startDeque = System.nanoTime();
        boolean resultDeque = checkWithDeque(normalized);
        long endDeque = System.nanoTime();

        // Recursive strategy
        long startRec = System.nanoTime();
        boolean resultRec = checkWithRecursion(normalized, 0, normalized.length() - 1);
        long endRec = System.nanoTime();

        // Display results
        System.out.println("\nResults for: \"" + input + "\"\n");

        System.out.println("Stack: " + (resultStack ? "Palindrome" : "Not Palindrome") +
                " | Time: " + (endStack - startStack) + " ns");

        System.out.println("Deque: " + (resultDeque ? "Palindrome" : "Not Palindrome") +
                " | Time: " + (endDeque - startDeque) + " ns");

        System.out.println("Recursion: " + (resultRec ? "Palindrome" : "Not Palindrome") +
                " | Time: " + (endRec - startRec) + " ns");

        scanner.close();
    }
}