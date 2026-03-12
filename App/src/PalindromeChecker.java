import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {

    // Enum to choose strategy
    enum Strategy {
        STACK,
        DEQUE
    }

    private Strategy strategy;

    public PalindromeChecker(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        // Normalize string: remove spaces, lowercase
        String str = input.replaceAll("\\s+", "").toLowerCase();

        // Apply chosen strategy
        if (strategy == Strategy.STACK) {
            return checkWithStack(str);
        } else {
            return checkWithDeque(str);
        }
    }

    // Stack-based palindrome check
    private boolean checkWithStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // Deque-based palindrome check
    private boolean checkWithDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: 1 = Stack, 2 = Deque");
        int choice = scanner.nextInt();

        Strategy strategy = (choice == 1) ? Strategy.STACK : Strategy.DEQUE;
        PalindromeChecker checker = new PalindromeChecker(strategy);

        boolean result = checker.checkPalindrome(input);

        System.out.println("\"" + input + "\"" + (result ? " is a Palindrome" : " is NOT a Palindrome"));

        scanner.close();
    }
}