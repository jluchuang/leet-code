public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vArray1 = version1.split("\\."); 
        String[] vArray2 = version2.split("\\."); 
        
        int minLen = vArray1.length > vArray2.length ? vArray2.length : vArray1.length; 
        for(int i = 0; i < minLen; i ++) {
            int val1 = Integer.valueOf(vArray1[i]); 
            int val2 = Integer.valueOf(vArray2[i]);  
            if(val1 != val2) {
                return val1 > val2 ? 1 : -1;  
            }
        }
        
        if(vArray1.length == vArray2.length) {
            return 0; 
        }
        
        // Just for "1.0" and "1"
        int sum1 = 0;
        int sum2 = 0; 
        for(int i = minLen; i < vArray1.length; i ++) {
            sum1 += Integer.valueOf(vArray1[i]); 
        }
        for(int i = minLen; i < vArray2.length; i ++) {
            sum2 += Integer.valueOf(vArray2[i]); 
        }
        
        if(sum1 == sum2 ) {
            return 0; 
        }
        
        return sum1 > sum2 ? 1 : -1; 
    }
}