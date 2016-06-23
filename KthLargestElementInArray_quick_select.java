// quick select: 3 ms

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k );
    }
    
    private int quickSelect(int[] nums, int st, int end, int k) {
        
        int range = end - st + 1; 
        int randIndex = (int)(Math.random() * range) + st;
        swap(nums, randIndex, end);
        
        int curIdx = st; 
        for(int i = st; i < end; i ++) {
            if(nums[i] > nums[end]) {
                swap(nums, curIdx, i); 
                curIdx ++; 
            }
        }
        swap(nums, curIdx, end); 
        
        if(curIdx == k - 1) {
            return nums[curIdx];
        }
        
        if(curIdx > k -1 && st < curIdx) {
            return quickSelect(nums, st, curIdx - 1, k); 
        }
        if(curIdx < k -1 && end > curIdx) {
            return quickSelect(nums, curIdx + 1, end, k);
        }
        
        return -1; 
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i]; 
        nums[i] = nums[j];
        nums[j] = tmp; 
    }
}