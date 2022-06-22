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

    /**
     * NOTE: Super sick solution from leetcode user phoenix13steve.
     * https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
     */

    // public boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<Character>();
    //     for (char c : s.toCharArray()) {
    //         if (c == '(')
    //             stack.push(')');
    //         else if (c == '{')
    //             stack.push('}');
    //         else if (c == '[')
    //             stack.push(']');
    //         else if (stack.isEmpty() || stack.pop() != c)
    //             return false;
    //     }
    //     return stack.isEmpty();
    // }
}
