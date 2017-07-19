package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class ParenthesesChecker {

    public boolean isValid(String parentheses) {
        Deque<Character> parens = new LinkedList<>();
        for (char c : parentheses.toCharArray()) {
            if (isOpen(c)) {
                parens.push(c);
            } else {
                char open = parens.pop();
                if (!match(open, c)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean match(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    private boolean isOpen(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    public static void main(String[] args) {
        ParenthesesChecker pc = new ParenthesesChecker();
        System.out.println(pc.isValid("{([])}"));
        System.out.println(pc.isValid("[[[[)]]]]"));
    }
}
