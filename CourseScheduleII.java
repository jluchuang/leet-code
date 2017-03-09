public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses]; 
        Map<Integer, List<Integer>> preMap = new HashMap<>(); 
        for(int i = 0; i < prerequisites.length; i++) {
            int ed = prerequisites[i][0]; 
            int st = prerequisites[i][1]; 
            
            inDegree[ed] ++; 
            
            List<Integer> pre = preMap.get(st); 
            if(pre == null) {
                pre = new ArrayList<Integer>(); 
            }
            pre.add(ed); 
            preMap.put(st, pre); 
        }
        
        int[] res = new int[numCourses]; 
        int pos = 0; 
        while(true) {
            boolean edFlag = true; 
            for(int i = 0; i < numCourses; i++) {
                if(inDegree[i] == 0) {
                    inDegree[i] = -1;
                    res[pos ++] = i; 
                    List<Integer> out = preMap.get(i); 
                    if(out != null) {
                        for(Integer ed : out) {
                            inDegree[ed] --; 
                        }
                    }
                    edFlag = false; 
                }
            }
            
            if(edFlag) {
                break;
            }
        }
        
        for(int i = 0; i < numCourses; i ++)  {
            if(inDegree[i] != -1) {
                return new int[0]; 
            }
        }
        
        return res; 
    }
}