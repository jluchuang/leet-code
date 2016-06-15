public class Solution {
    public int calculate(String s) {
        Stack<Character> opts = new Stack<Character>();
        Stack<Long> nums = new Stack<Long>(); 
        
        char[] expression = s.toCharArray();
        
        int i = 0; 
        while (i < expression.length) {
            char c = expression[i]; 
            if(c == ' ') {
                i ++;
                continue; 
            }
            
            // operaters
            if(c == '+' || c == '-' || c == '(' || c == ')') {
                switch(c) {
                    case '+': {
                        opts.push(c);
                        break; 
                    }
                    case '-': {
                        opts.push(c);
                        break;
                    }
                    case '(': {
                        opts.push(c);
                        break;
                    }
                    case ')': {
                        char opt = opts.peek(); 
                        Stack<Long> lToRNums = new Stack<Long>();
                        Stack<Character> lToROpts = new Stack<Character>();
                        while(opt != '(') {
                            lToRNums.push(nums.pop()); 
                            
                            lToROpts.push(opt); 
                            opts.pop();
                            opt = opts.peek();
                        }
                        lToRNums.push(nums.pop());
                        nums.push(calculate(lToRNums, lToROpts)); 
                        opts.pop();
                    }
                }
                i ++; 
                continue; 
            }
            
            // operater numbers
            String opNumber = new String(); 
            while(true) {
                if(c > '9' || c < '0' ) {
                    break;
                }
                opNumber += c; 
                i ++;
                if(i >= expression.length) {
                    break;
                }
                c = expression[i];
            }
            nums.push(Long.valueOf(opNumber)); 
        }
        
        
        Stack <Long> lToRNums =  new Stack<Long>();
        Stack <Character> lToROpts = new Stack<Character>();
        while(!opts.empty()) {
            lToROpts.push(opts.pop()); 
            lToRNums.push(nums.pop());
        }
        lToRNums.push(nums.pop());
        
        Long res = calculate(lToRNums, lToROpts); 
        return res.intValue();
        
    }
    
    private long calculate(Stack<Long> nums, Stack<Character> opts) {
        while(!opts.empty()) {
            long left = nums.pop();
            long right = nums.pop();
            nums.push(calculate(left, right, opts.pop())); 
        }
        
        if(nums.empty()) {
            return 0; 
        }
        
        return nums.pop();
    }
    
    private long calculate(long left, long right, char opt) {
        switch(opt) {
            case '+': {
                return (left + right); 
            }
            case '-': {
                return (left - right); 
            }
        }
        return -1; 
    }
}



