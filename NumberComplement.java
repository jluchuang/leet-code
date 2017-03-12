public class Solution {
    public int findComplement(int num) {
        int tmp = num; 
        
        int res = 0; 
        int weight = 1;  
        while(tmp != 0) {
            int bit = tmp & 1;
            if(bit == 0) {
               res |= weight; 
            }
            weight = weight << 1; 
            tmp = tmp >> 1;  
        }
        
        return res; 
    }
}