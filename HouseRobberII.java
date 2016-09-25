public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0; 
        }
        
        if(nums.length == 1) {
            return nums[0]; 
        }
        
        int fir = rob(nums, 0, nums.length - 2);
        int sec = rob(nums, 1, nums.length - 1); 
        return Math.max(fir, sec); 
    }
    
    private int rob(int[] nums, int st, int ed) {
        if(st > ed) {
            return 0; 
        }
        
        if(st == ed) {
            return nums[st]; 
        }
        
        int preYes = nums[st]; 
        int preNo = 0; 
        
        for(int i = st + 1; i <= ed; i ++) {
            int tmpNo = Math.max(preYes, preNo);
            preNo += nums[i]; 
            
            preYes = preNo;
            preNo = tmpNo; 
        }
        
        return Math.max(preYes, preNo); 
    }
}