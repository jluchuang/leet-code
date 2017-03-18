public class Solution {
    public String frequencySort(String s) {
        int len = s.length(); 
        
        Map<Character, Integer> fMap = new HashMap<>();
        
        for(int i = 0; i < len; i ++) {
            char tmp = s.charAt(i); 
            Integer f = fMap.get(tmp); 
            
            if(f != null) {
                fMap.put(tmp, f + 1); 
            }
            else {
                fMap.put(tmp, 1); 
            }
        }
        
        FNode[] fns = new FNode[fMap.size()]; 
        int idx = 0;
        for(Map.Entry<Character, Integer> me : fMap.entrySet() ){
            FNode tmp = new FNode(me.getKey(), me.getValue()); 
            
            fns[idx ++] = tmp; 
        }
        
        // Heap Sort
        int heapSize = fns.length - 1; 
        for(int i = 0; i < fns.length; i ++) {
            for(int k = heapSize / 2; k >= 0; k --) {
                int maxIdx = k;
                int l = 2 * k; 
                if(fns[k].freq > fns[l].freq) {
                    maxIdx = l; 
                }
                int r = 2 * k + 1; 
                if(r <= heapSize && fns[maxIdx].freq > fns[r].freq) {
                    maxIdx = r; 
                }
                
                if(maxIdx != k) {
                    swap(fns, maxIdx, k); 
                }
            }
            
            swap(fns, 0, heapSize);
            heapSize --; 
        }
        
        // result
        char[] resArray = new char[len]; 
        int resIdx = 0; 
        for(int i = 0; i < fns.length; i ++) {
            for(int j = 0; j < fns[i].freq; j ++) {
                resArray[resIdx ++] = fns[i].c; 
            }
        }
        
        return new String(resArray); 
    }
    
    public class FNode {
        Character c; 
        Integer freq; 
        
        FNode(Character c, Integer freq) {
            this.c = c; 
            this.freq = freq; 
        }
    }
    
    void swap(FNode[] fns, int i, int j) {
        FNode tmp = fns[i]; 
        fns[i] = fns[j]; 
        fns[j] = tmp; 
    }

}