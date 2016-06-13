/**
Use a stack instead of reconstructing the tree.
From left to right, if we get substring like  "1,#,#", 
then we just treat the specified substring as a "#".

So finally there should be a last "#" in the stack.  
*/

public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack <Character> s = new Stack<Character>(); 
        
        String[] nodes = preorder.split(",");
        
        if(nodes.length == 0) {
            return false;
        }
        
        s.push(nodes[0].charAt(0));
        
        int len = nodes.length;
        int pos = 1;
        while(true) {
            if( pos >= len )  break; 
            char tmp = nodes[pos].charAt(0);
            if(tmp == '#') {
                while(!s.empty() && s.peek() == '#') {
                    s.pop(); 
                    if(s.empty()) {                     // double '#' no father
                        return false;
                    }
                    s.pop();                            // pop one branch like "1,#,#" and continue to see stack top
                }
                s.push('#');
            }
            else {
                s.push(tmp);
            }
            pos ++; 
        }
        
        if(s.empty()) {                                // there should be a last '#' in the stack
            return false; 
        }
        
        char c = s.pop(); 
        if(c != '#') { 
            return false;                              // not just one '#' in the stack
        }
        
        if(!s.empty()) {
            return false; 
        }
        
        return true;
    }
}