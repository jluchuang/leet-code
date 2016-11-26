/**
 * An easy approach is to sort the array first.  Ans: clear not the best O(n^2)
 * What are the possible values of h-index?   Ans: 0~n  
 * A faster approach is to use extra space.   Ans: 维持一个hidx[0..n]，用来存储, hidx[i]表示引用数等于i的文章数量
 * 特殊处理： 对于引用数大于n的文章， 看做引用数等于n的文章
 **/
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length; 
        int[] hIdx = new int[n + 1]; 
        
        for(int i = 0; i < n; i ++) {
            int idx = citations[i] > n ? n : citations[i];
            
            hIdx[idx] += 1; 
        }
        
        int hnum = 0; 
        for(int h = n; h >= 0; h--) {
            hnum += hIdx[h]; 
            if(hnum >= h) {
                return h; 
            }
        }
        
        return 0; 
    }
}