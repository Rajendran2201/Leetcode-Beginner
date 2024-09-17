class MinStack {
    Stack<Long> stack;
    long min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        long value = (long)val;
        if(stack.isEmpty()){
            stack.push(value);
            min = value;
        }else{
            if(value > min){
                stack.push(value);
            }else{
                // add the modified value to the stack 
                long modified_value = (2 * value) - min;
                stack.push(modified_value);
                min = value;
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){return;}
        long modified_value = stack.peek();
        if(modified_value < min){
            stack.pop();
            min = 2 * min - modified_value;
        }else{
            // The value is not at all modified
            stack.pop();
        }
    }
    
    public int top() {
        long top_value = stack.peek();
        if(top_value < min){
            return (int) min;
        }
        return (int) top_value;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */