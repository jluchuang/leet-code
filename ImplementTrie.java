class TrieNode {
    // Initialize your data structure here.
    public TrieNode[] next = new TrieNode[26]; 
    public boolean isEnd = false; 
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode tmp = root; 
        for(int i = 0; i < word.length(); i ++) {
            int idx = word.charAt(i) - 'a'; 
            if(tmp.next[idx] == null) {
                tmp.next[idx] = new TrieNode(); 
            }
            tmp = tmp.next[idx]; 
        }
        tmp.isEnd = true; 
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tmp = root; 
        for(int i = 0; i < word.length(); i ++) {
            int idx = word.charAt(i) - 'a'; 
            if(tmp.next[idx] == null) {
                return false; 
            }
            tmp = tmp.next[idx]; 
        }
        if(tmp == null) {
            return false; 
        }
        return tmp.isEnd; 
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
                TrieNode tmp = root; 
        for(int i = 0; i < prefix.length(); i ++) {
            int idx = prefix.charAt(i) - 'a'; 
            if(tmp.next[idx] == null) {
                return false; 
            }
            tmp = tmp.next[idx]; 
        }
        if(tmp == null) {
            return false; 
        }
        return true; 
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");