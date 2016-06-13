public class MinStack {
    
    Stack <Pair> s; 

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<Pair>(); 
    }
    
    public void push(int x) {
        if(!s.empty()) {
            Pair top = s.peek(); 
            if(top.getMin() > x) {
                s.push(new Pair(x, x));
            }
            else {
                s.push(new Pair(x, top.getMin())); 
            }
        }
        else {
           s.push(new Pair(x, x));  
        }
    }
    
    public void pop() {
        if(!s.empty()) {
            s.pop(); 
        }
    }
    
    public int top() {
        if(!s.empty()) {
            return s.peek().getTop(); 
        }
        return -1;
    }
    
    public int getMin() {
        if(!s.empty()) {
            return s.peek().getMin(); 
        }
        return -1;
    }
    
    private class Pair {
        int top; 
        int min; 
        
        public Pair(int _top, int _min) {
            top = _top; 
            min = _min; 
        }
        
        public int getTop() {
            return top; 
        }
        
        public int getMin() {
            return min; 
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */