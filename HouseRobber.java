public class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        
        if(nums.length == 0) {
            return 0; 
        }
        
        if(nums.length == 1) {
            return nums[0]; 
        }
        
        if(nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1]; 
        }
        
        if(nums.length == 3) {
            return nums[1] > nums[0] + nums[2] ? nums[1] : nums[2] + nums[0]; 
        }
        
        dp[0] = nums[0];
        dp[1] = nums[1]; 
        dp[2] = nums[2] + dp[0];
        for(int i = 3; i < nums.length; i++) {
            int max = dp[i-2];
            if(dp[i-2] < dp[i-3]) {
                max = dp[i-3]; 
            }
            dp[i] = max + nums[i]; 
        }
        
        return dp[nums.length - 1] > dp[nums.length - 2] ? dp[nums.length -1] : dp[nums.length - 2];  
    }


 //    public int rob(int[] num) {
 //    	int prevNo = 0;
 //    	int prevYes = 0;
 //    	for (int n : num) {
 //        	int temp = prevNo;
 //        	prevNo = Math.max(prevNo, prevYes);
 //        	prevYes = n + temp;
 //    	}
 //    	return Math.max(prevNo, prevYes);
 //    }
}

}