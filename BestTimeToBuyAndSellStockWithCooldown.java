public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
  
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
 
        for(int i = 1; i < prices.length; i++) {
    	    b0 = Math.max(b1, s2 - prices[i]);
    	    s0 = Math.max(s1, b1 + prices[i]);
    	    b1 = b0; s2 = s1; s1 = s0; 
        }
        return s0;
    }
    /*public int maxProfit(int[] prices) {
        int len = prices.length; 
        if(len == 0) {
            return 0; 
        }
        int[][] dp = new int[len][len];
        
        for(int i = 0; i < len; i++ ) {
            dp[i][i] = 0;
            if(i != len - 1) {
               dp[i][i + 1] = (prices[i + 1] > prices[i]) ? (prices[i+1] - prices[i]) : 0; 
            }
        }
        
        int l = 2; 
        for( ; l <= len; l ++) {
            for(int st = 0; st + l < len; st++) {
                int end = st + l; 
                dp[st][end] = (prices[end] > prices[st]) ? (prices[end] - prices[st]) : 0;
                for(int c = 0; c <= l; c++) {
                    int tmp = 0; 
                    if(l - c >= 2) {
                        tmp = dp[st][st + c] + dp[st + c + 2][end]; 
                    }
                    
                    if(tmp > dp[st][end]) {
                        dp[st][end] = tmp; 
                    }
                }
                if(dp[st][end - 1] > dp[st][end]) {
                    dp[st][end] = dp[st][end - 1];  
                }
                if(dp[st + 1][end] > dp[st][end]) {
                    dp[st][end] = dp[st + 1][end]; 
                }
            }
        }
        
        return dp[0][len - 1]; 
    }*/
}