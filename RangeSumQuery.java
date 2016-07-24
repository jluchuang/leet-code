public class NumArray {

    int[] array = null;
    int[] sumRanges = null; 

    public NumArray(int[] nums) {
        array = new int[nums.length];
        sumRanges = new int[nums.length]; 
        
        if(nums.length > 0) {
            array[0] = nums[0]; 
            sumRanges[0] = nums[0]; 
        }
        
        for(int i = 1; i < nums.length; i ++ ) {
            array[i] = nums[i]; 
            sumRanges[i] = sumRanges[i - 1] + nums[i]; 
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int beg = i > 0 ? i : 0; 
        int end = j < array.length ? j : 0; 
        
        return sumRanges[end] - sumRanges[beg] + array[beg]; 
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);