public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int st = 0; 
        int end = numbers.length - 1; 
        
        int[] res = new int[2]; 
        while (st < end) {
            int sum  = numbers[st] + numbers[end]; 
            
            if(sum == target) {
                res[0] = st + 1; 
                res[1] = end + 1; 
                break; 
            }
            
            if(sum > target) {
                end --; 
            }
            else {
                st ++; 
            }
        }
        return res; 
    }
}