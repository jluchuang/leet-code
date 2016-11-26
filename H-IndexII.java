public class Solution {
    /*public int hIndex(int[] citations) {
        int n = citations.length; 
        if(n > 0 && citations[0] >= n) {
            return n; 
        }
        for(int i = n - 1; i >= 0; i--){ 
            int c = citations[i] > n ? n : citations[i]; 
            
            if(n - i == c) {
                return c; 
            }
            
            if(n - i > c) {
                // we need to get the max h
                return (n - i -1); 
            }
        }
        
        return 0; 
    }*/
    
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int l = 0, r = citations.length;
        int n = citations.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(citations[mid] == n - mid) return n - mid;
            if(citations[mid] < citations.length - mid) l = mid + 1;
            else r = mid;
        }
        return n - l;
    }
}