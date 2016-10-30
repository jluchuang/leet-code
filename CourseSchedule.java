/*
 * Topological sorting
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses]; 
        for(int i = 0; i < numCourses; i++) {
            inDegree[i] = 0; 
        }
        
        for(int i = 0; i < prerequisites.length; i ++) {
            inDegree[prerequisites[i][0]] ++; 
        } 
        
        for(int i = 0; i < numCourses; i ++) {
            // pick point that indegree is 0
            int cut = -1; 
            for(int p = 0; p < numCourses; p ++) {
                if(inDegree[p] == 0) {
                    cut = p; 
                }
            }
            if(cut == -1) {
                return false; 
            }
            
            inDegree[cut] = -1; 
            for(int j = 0; j < prerequisites.length; j ++) {
                if(prerequisites[j][1] == cut) {
                    inDegree[prerequisites[j][0]] --; 
                }
            }
        }
        boolean flag = true; 
        for(int i = 0; i < numCourses; i ++) {
            if(inDegree[i] != -1) {
                return false; 
            }
        }
        return flag; 
    }
}