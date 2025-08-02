class Solution {
    public String removeOuterParentheses(String s) {
        /*
        Algorithm:
            - The approach used is to keep track of the parentheses using a stack. 
            - Whenever an opening parenthesis is encountered, it is pushed onto the stack. 
            - Whenever a closing parenthesis is encountered, the last opening parenthesis is popped from the stack.
            - If the stack size is greater than zero before pushing or after popping, it means that the parenthesis is not an outer parenthesis, and it is added to the result string. 
            - If the stack size is zero, it means that the parenthesis is an outer parenthesis and it is not added to the result string.
        */
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray()){
            // handling open parenthesis
            if(ch == '('){
                // push it into stack
                // but before that check if it's size is greater than 0 
                if(st.size() > 0){
                    sb.append(ch);
                }
                st.push(ch);
            }
            // handling closing parenthesis
            else if(ch == ')'){
                st.pop();
                if(st.size() > 0){
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
