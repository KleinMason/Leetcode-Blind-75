package Valid_Parentheses;

import java.util.Stack;

/**
 * NOTE: Push opening parentheses to the stack. Pop the 
 * stack if matching closing parenthese is found.
 * If stack is empty at the end return true.
 */

public class solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (stack.empty()) return false;
            else if (c == ')' && stack.pop() != '(') return false;
            else if (c == '}' && stack.pop() != '{') return false;
            else if (c == ']' && stack.pop() != '[') return false;
        }
        return stack.empty();
    }
}
