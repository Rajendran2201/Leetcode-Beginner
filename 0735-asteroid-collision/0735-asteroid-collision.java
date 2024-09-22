class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<asteroids.length; i++){
            int num = asteroids[i];
            if(num > 0){
                stack.push(num);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(num)){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(num);
                }
                if(!stack.isEmpty() && stack.peek() == Math.abs(num)){
                    stack.pop();
                    
                }
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty()){
            res[i--] = stack.pop();
        }

        return res;
        
    }

}