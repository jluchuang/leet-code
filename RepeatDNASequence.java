public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        if(s.length() < 10) {
            return new ArrayList<String>(); 
        }
        
        List<String> res = new ArrayList<String>();
        
        Set<Long> set = new HashSet<Long>();
        Set<String> resSet = new HashSet<String>();
        int length = s.length(); 
        int i = 0;
        long num = 0; 
        while (i != 10) {
            num = num << 2;
            num = num | getInt(s.charAt(i)); 
            i ++;
        }
        set.add(num);
        
        for(; i < length; i++) {
            num = num << 2; 
            num = num & 0xfffff;
            num = num | getInt(s.charAt(i));
            
            if(set.contains(num) && !resSet.contains(s.substring(i-9, i + 1))) {
                resSet.add(s.substring(i-9, i + 1)); 
            }
            else {
                set.add(num); 
            }
        }
        
        res.addAll(resSet); 
        
        return res;
    }
    
    int getInt(char a) {
        switch(a) {
            case 'A':
                return 0; 
            case 'G':
                return 1; 
            case 'C':
                return 2; 
            case 'T':
                return 3;
        }
        return -1; 
    }
}