import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList();

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            Character top = stack.peek();

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (
                top != null &&
                (
                    (top == '[' && current == ']') ||
                    (top == '(' && current == ')') ||
                    (top == '{' && current == '}')
                )
            ) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
