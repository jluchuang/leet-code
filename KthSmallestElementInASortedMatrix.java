public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(); 
        
        // init 
        for(int i = 0; i < matrix[0].length; i++) {
            pq.add(new Tuple(0, i, matrix[0][i])); 
        }
        
        // get k - 1 
        for(int i = 0; i < k - 1; i ++ ){
            Tuple tmp = pq.poll(); 
            if(tmp.x >= matrix.length - 1) continue; 
            pq.add(new Tuple(tmp.x + 1, tmp.y, matrix[tmp.x + 1][tmp.y])); 
        }
        
        return pq.poll().val; 
    }
    
    public class Tuple implements Comparable<Tuple> {
        int x, y, val; 
        
        public Tuple(int x, int y, int val) {
            this.x = x; 
            this.y = y; 
            this.val = val; 
        }
        
        @Override 
        public int compareTo(Tuple that) {
            return this.val - that.val; 
        }
    }
}