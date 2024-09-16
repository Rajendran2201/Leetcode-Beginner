class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Iterate over each character in the string
        for(char c : s.toCharArray()) {
            // Push opening brackets to the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // If it's a closing bracket, ensure the stack is not empty before popping
                if (stack.isEmpty()) {
                    return false;
                }
                // Check if the closing bracket matches the top of the stack
                char top = stack.pop(); // Pop the top element
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        // Ensure the stack is empty at the end (all brackets matched)
        return stack.isEmpty();
    }
}