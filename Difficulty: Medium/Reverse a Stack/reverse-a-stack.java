// User function Template for Java
import java.util.Stack;

class Solution {
    static void reverse(Stack<Integer> s) {
        Stack<Integer> result = new Stack<>();
        reversedStack(s, result);
        // Copy reversed elements back to 's'
        while (!result.isEmpty()) {
            s.push(result.pop());
        }
    }

    static void reversedStack(Stack<Integer> s, Stack<Integer> result) {
        if (s.isEmpty()) {
            return;
        }
        int temp = s.pop();
        reversedStack(s, result); // Recursively process remaining elements
        result.push(temp); // Push to 'result' in reverse order
    }
}
