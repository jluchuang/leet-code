// 14 ms 

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0; 
        }
        
        int len = nums.length; 
        
        int[] dp = new int[len]; 
        boolean[] flag = new boolean[len]; 
        for(int i = 0; i < len; i ++) {
            dp[i] = 1; 
            flag[i] = false; 
        }
        
        for(int i = 1; i < len; i ++) {
        
            for(int j = 0; j < i; j ++) {
            
                if(nums[i] == nums[j] && dp[j] > dp[i]) {
                    dp[i] = dp[j]; 
                    flag[i] = flag[j];
                    continue; 
                }
                
                if((nums[i] > nums[j] && flag[j] && dp[j] + 1 > dp[i]) || 
                    (nums[i] > nums[j] && dp[j] == 1 && dp[j] + 1 > dp[i])) {
                    dp[i] = dp[j] + 1; 
                    flag[i] = false;
                    continue; 
                }
                    
                if((nums[i] < nums[j] && !flag[j] && dp[j] + 1 > dp[i])) {
                    dp[i] = dp[j] + 1; 
                    flag[i] = true;
                    continue;
                }
            }
        }
        
        
        int res = 1; 
        for(int i = 1; i < len; i ++) {
            if(dp[i] > res) {
                res = dp[i]; 
            }
        }
        
        return res;
    }
}