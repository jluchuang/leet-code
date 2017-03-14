public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>(); 
        
        if(nums == null || nums.length == 0) {
            return res; 
        }
        
        int len = nums.length; 
        
        for(int i = 0; i < len; i ++) {
            int tmp = nums[i]; 
            
            if(tmp < 0) {
                tmp = -tmp; 
            }
            
            if(nums[tmp - 1] > 0 ) {
                nums[tmp - 1] = -nums[tmp - 1]; 
            } 
            else {
                res.add(tmp); 
            }
        }
        
        for(int i = 0; i < len; i ++) {
            if(nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }
        
        return res; 
    }
}