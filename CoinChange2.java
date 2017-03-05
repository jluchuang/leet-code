public class Solution {
    private class Stat{
        public int maxN; 
        public int left; 
        
        Stat(int left, int maxN) {
            this.maxN = maxN; 
            this.left = left; 
        }
    }
    
    public int change(int amount, int[] coins) {
        
        int dp[] = new int[amount + 1]; 
        
        dp[0] = 1; 
        
        for(int i = 0; i < coins.length; i ++) {
            for(int a = coins[i]; a <= amount; a ++) {
                dp[a] += dp[a - coins[i]]; 
            }
        }
        
        return dp[amount]; 
        
        /*if(amount == 0) {
            return 1; 
        }
        
        if(coins == null) {
            return 0; 
        }
        
        int res = 0;
        
        int maxN = 0; 
        for(int i = 0; i < coins.length; i++) {
            if(maxN < coins[i]) {
                maxN = coins[i]; 
            }
        }
        Stat init = new Stat(amount, maxN); 
        
        Queue<Stat> q = new LinkedList(); 
        q.add(init); 
        
        while(!q.isEmpty()) {
            Stat cur = q.poll(); 
            
            for(int i = 0; i < coins.length; i++ ) {
                
                if(cur.left == coins[i] && coins[i] <= cur.maxN) { // Get one solution
                    res ++;
                    continue; 
                }
                
                // Add next Stat if necessary
                if(coins[i]  <= cur.maxN && cur.left > coins[i]) {
                    Stat ns = new Stat(cur.left - coins[i], coins[i]); 
                    q.add(ns); 
                }
                
            }
        }
        
        return res;*/ 
    }

}