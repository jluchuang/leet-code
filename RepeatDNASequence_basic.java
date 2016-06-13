public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        if(s.length() < 10) {
            return new ArrayList<String>(); 
        }
        
        Set<String> set = new HashSet<String>();
        Set<String> resSet = new HashSet<String>(); 
        
        for(int i = 10; i <= s.length(); i ++) {
            String tmp = s.substring(i-10, i); 
            if(set.contains(tmp) && !resSet.contains(tmp)) {
                resSet.add(tmp); 
            }
            else {
                set.add(tmp); 
            }
        }
        
        return new ArrayList<String>(resSet); 
    }
    
}