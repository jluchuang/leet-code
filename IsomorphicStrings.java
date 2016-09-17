public class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Character> mp = new HashMap<Character, Character>(); 
        Map<Character, Character> mpRev = new HashMap<Character, Character>(); 
        
        for(int i = 0; i < s.length(); i ++) {
            char tmp = s.charAt(i); 
            char repT = t.charAt(i); 
            
            Character rep = mp.get(tmp); 
            if(rep == null) {
                if(!mpRev.containsKey(repT) || mpRev.get(repT).equals(tmp)) {
                    mp.put(tmp, repT);
                    mpRev.put(repT, tmp); 
                    continue;
                } 
                return false; 
            }
            
            if(!rep.equals(repT)) {
                return false; 
            }
            if(mpRev.containsKey(repT) && !mpRev.get(repT).equals(tmp)) {
                return false;
            }
            
        }
        
        return true; 
    }
}