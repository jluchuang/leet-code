// Heap sort 130+ ms

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for(int i = 1; i <= k; i ++) {
            int heapSize = len - i;
            if(heapSize == 0) {
                break;
            }
            for(int j = heapSize / 2; j >= 0; j --) {
                int max = j; 
                int left = 2 * j; 
                int right = left + 1;
                
                if(j == 0) {
                    left  = 1;
                    right = 2;
                }
                
                if(nums[max] < nums[left]) {
                    max = left; 
                }
                if(right <=  heapSize && nums[max] < nums[right]) {
                    max = right; 
                }
                if(max != j) {
                    swap(nums, max, j); 
                }
            }
            swap(nums, heapSize, 0); 
        }
        
        return nums[len - k]; 
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i]; 
        nums[i] = nums[j];
        nums[j] = tmp; 
    }
}