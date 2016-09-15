
public class Solution {
    public int findPeakElement(int[] nums) {
        //corner case
        if (nums.length==0 || nums==null){
            return 0;
        }
        int start=0;
        int end= nums.length-1;
        
        while(start+1<end){
            int mid = start+ (end-start)/2;
             //peak
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            //decreasing
            else if(nums[mid]<nums[mid-1]){
                end=mid;
            }
            //increasing & lowest (A[mid]>A[mid-1]) && (A[mid]<A[mid-1]&& A[mid]>A[mid+1]
            else{
                start=mid;
            }
            
        }
        if(nums[start]>nums[end]){
            return start;
        }
        else{
            return end;
        }
        
    }
}