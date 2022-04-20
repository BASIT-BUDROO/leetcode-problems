package ValidParentheses;

import java.util.EmptyStackException;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                try {
                    if (s.charAt(i) == ')' && stack.peek() == '(') {
                        stack.pop();

                    } else if (s.charAt(i) == '}' && stack.peek() == '{') {
                        stack.pop();

                    } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                        stack.pop();

                    } else return false;
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        String s = "(";
        System.out.println(solution.isValid(s));

    }
}
