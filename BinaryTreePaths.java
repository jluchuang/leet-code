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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>(); 
        
        if(root != null) {
            String cur = "" + root.val;
            if(root.left == null && root.right == null) {
                res.add(cur); 
                return res; 
            }
            if(root.left != null) {
                binaryTreePath(cur, res, root.left); 
            }
            if(root.right != null) {
                binaryTreePath(cur, res, root.right); 
            }
        }
        return res;
    }
    
    private void binaryTreePath(String cur, List<String> res, TreeNode curNode) {
        if(curNode.left == null && curNode.right == null) {
            cur = cur + "->" + curNode.val; 
            res.add(cur); 
            return; 
        }
        
        if(curNode.left != null) {
            String left = cur + "->" + curNode.val; 
            binaryTreePath(left, res, curNode.left); 
        }
        
        if(curNode.right != null) {
            String right = cur + "->" + curNode.val; 
            binaryTreePath(right, res, curNode.right); 
        }
    }
}