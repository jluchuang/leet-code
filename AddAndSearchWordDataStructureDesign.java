public class WordDictionary {
    
    WordNode tried = new WordNode(); 
    
    public class WordNode { 
        public WordNode[] node = new WordNode[26];
        public boolean endFlag = false; 
        
        public WordNode() {
            for(int i = 0; i < 26; i ++) {
                node[i] = null; 
            }
        }
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        WordNode tmp = tried;  
        int index = 0; 
        for(int i = 0; i < word.length(); i ++) {
            index = word.charAt(i) - 'a'; 
            if(tmp.node[index] == null) {
                tmp.node[index] = new WordNode();
            }
            tmp = tmp.node[index]; 
        }
        tmp.endFlag = true; 
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, tried); 
    }
    
    private boolean search(String word, WordNode tree) {
        if(tree == null) {
            return false; 
        }
        if(word.length() == 0) {
            return tree.endFlag; 
        }
        
        char c = word.charAt(0); 
        if(!(c =='.')) {
            int idx = c - 'a'; 
            return search(word.substring(1), tree.node[idx]);
        }
        
        String sub = word.substring(1); 
        for(int i = 0; i < 26; i++) {
            if(tree.node[i] != null) {
                if(search(sub, tree.node[i])) {
                    return true; 
                } 
            }
        }
        return false; 
    }
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");