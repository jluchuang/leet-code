/**
 * Basic Idea dfs
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        List<Integer> curCom = new ArrayList<Integer>();
        
        combinationSum(k, n, curCom, res); 
        
        return res; 
    }
    
    private void combinationSum(int k, int n, List<Integer> curCom, List<List<Integer>> res) {
        int lastPick = n > 9 ? 10 : n; 
        if(curCom.size() != 0) {
            lastPick = curCom.get(curCom.size() - 1);
        } 
        
        if(k == 1 && n < lastPick && n != 0) {
            List<Integer> curAns = new ArrayList<Integer>(curCom); 
            curAns.add(n); 
            res.add(curAns);
            return; 
        }

        for(int i = lastPick - 1; i > 0; i --) {
            if(n < i) {
                continue; 
            }
            curCom.add(i); 
            combinationSum(k - 1, n - i, curCom, res); 
            curCom.remove(curCom.size() - 1); 
        } 
    }
}