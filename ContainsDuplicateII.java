public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean res = false; 
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for(int i = 0; i < nums.length; i ++) {
            int key = nums[i]; 
            if(map.containsKey(key)) {
                int pre = map.get(key); 
                if(i - pre <= k) {
                    return true; 
                }
            }
            map.put(key, i); 
        }
        return false; 
    }
}