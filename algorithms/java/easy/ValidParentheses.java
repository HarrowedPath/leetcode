package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        boolean expectedOutput = true;
        assert expectedOutput == new ValidParentheses().isValid("()");
        assert expectedOutput == new ValidParentheses().moreIntuitiveSolution("()");
    }

    public boolean isValid(String s) {
        Deque<Character> characters = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                characters.push(')');
            } else if (c == '{') {
                characters.push('}');
            } else if (c == '[') {
                characters.push(']');
            } else if (characters.isEmpty() || characters.pop() != c) {
                return false;
            }
        }
        return characters.isEmpty();
    }

    public boolean moreIntuitiveSolution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> stack.push('(');
                case '{' -> stack.push('{');
                case '[' -> stack.push('[');
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                default -> throw new IllegalArgumentException("wrong argument");
            }
        }
        return stack.isEmpty();
    }
}
