public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        
        for(int i = 0; i < nums.length; i ++) {
            Integer tmp = map.get(nums[i]); 
            if(tmp == null) {
                map.put(nums[i], 1); 
            }
            else {
                tmp += 1; 
                map.put(nums[i], tmp); 
            }
        }
        
        int majority = nums.length / 2; 
        int res = -1; 
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int times = (Integer)pair.getValue(); 
            if(times > majority) {
                res = (Integer)pair.getKey(); 
            }
        }
        
        return res; 
    }
}