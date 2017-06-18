package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {

    boolean isValid(String parens) {
        Deque<Character> open = new LinkedList<>();

        for (char c : parens.toCharArray()) {
            if (isOpen(c)) {
                open.push(c);
            } else {
                char lastOpen = open.pop();
                if (!match(c, lastOpen)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isOpen(char c) {
        return (c == '{' ||
                c == '[' ||
                c == '(');
    }

    private boolean match(char close, char open) {
        if (close == '}') {
            return open == '{';
        } else if (close == ')') {
            return open == '(';
        } else {
            return open == '[';
        }
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();

        String str = "(][])";
        String str1 = "([]){}[]";

        System.out.println(vp.isValid(str));
        System.out.println(vp.isValid(str1));
    }
}
