public class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> countMap1 = new HashMap(); 
        Map<Character, Integer> countMap2 = new HashMap(); 
        
        for(int i = 0; i < s.length(); i++) {
            Integer count = countMap1.get(s.charAt(i)); 
            if(count == null) {
                countMap1.put(s.charAt(i), 1); 
            }
            else {
                countMap1.put(s.charAt(i), count + 1); 
            }
        }
        
        for(int i = 0; i < t.length(); i++) {
            Integer count = countMap2.get(t.charAt(i)); 
            if(count == null) {
                countMap2.put(t.charAt(i), 1); 
            }
            else {
                countMap2.put(t.charAt(i), count + 1); 
            }
        }
        
        for(Character key : countMap1.keySet()) {
            Integer count = countMap1.get(key); 
            Integer count2 = countMap2.get(key);
            
            if(count2 == null || !count2.equals(count)) {
                return false;
            }
        }
        
        return true; 
    }
}