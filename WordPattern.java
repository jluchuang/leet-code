public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null) {
            return false;
        }
        
        String[] words = str.split(" "); 
        if(words.length != pattern.length()) {
            return false; 
        }
        
        Map<Character, String> bijection = new HashMap<Character, String>(); 
        Set<String> wordSet = new HashSet<String>();
        for(int i = 0; i < pattern.length(); i ++ ) {
            char pat = pattern.charAt(i);
            String tmp = bijection.get(pat); 
            String word = words[i];
            
            if(tmp == null && wordSet.contains(word)) {
                return false;
            }
            
            if(tmp == null) {
                bijection.put(pat, word);
                wordSet.add(word);
                continue;
            }
            
            if(tmp.compareTo(word) != 0) {
                return false;
            }
        }
        
        return true; 
    }
}