/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(root == null) {
            return res; 
        }
        
        List<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root); 
        while (!q.isEmpty()) {
            TreeNode tmp = q.get(q.size() - 1);
            res.add(tmp.val);
            
            List<TreeNode> nextLevel = new ArrayList<TreeNode>(); 
            for(TreeNode tn : q) {
                if(tn.left != null) {
                    nextLevel.add(tn.left); 
                }
                if(tn.right != null) {
                    nextLevel.add(tn.right); 
                }
            }
            q = nextLevel; 
        }
        
        return res;
    }
}