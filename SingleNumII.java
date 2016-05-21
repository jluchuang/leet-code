public class Solution {
    public int singleNumber(int[] nums) {
        int oneTimes = 0; 
        int twoTimes = 0;
        
        for(int i = 0; i < nums.length; i ++) {
            
            twoTimes = twoTimes | (oneTimes & nums[i]);
            
            oneTimes = oneTimes ^ nums[i];
            
            int three = oneTimes & twoTimes;  
            
            twoTimes = twoTimes ^ three;
            oneTimes = oneTimes ^ three; 
            
        }
        
        return oneTimes; 
        
    }
}