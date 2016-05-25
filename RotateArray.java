public class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums == null) { 
            return; 
        }
        
        int len = nums.length; 
        int rk = k % len; 
        
        if(rk == 0) { 
            return;  
        }
        
        reverse(nums, 0, len - rk -1); 
        reverse(nums, len - rk, len - 1);  
        
        reverse(nums, 0, len - 1); 
    }
    
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start]; 
            nums[start] = nums[end];
            nums[end] = tmp; 
            
            start ++;  
            end --; 
        } 
    }
}