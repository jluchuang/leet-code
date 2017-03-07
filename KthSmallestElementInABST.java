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
    /*public int kthSmallest(TreeNode root, int k) {
        // try to use dfs 
        
        int i = 0; 
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        TreeNode r = root; 
        while(true) {
            if(r != null) {
                s.push(r); 
                r = r.left; 
            }
            else {
                i ++;
                r = s.pop();
                if(i == k) {
                    break;
                }
                r = r.right; 
            }
        }
        return r.val; 
    } */
    
    public int kthSmallest(TreeNode root, int k) {
        int c = countNodes(root.left); 
        
        if(k == c + 1) {
            return root.val; 
        }
        
        if(k < c + 1) {
            return kthSmallest(root.left, k); 
        }
        else {
            return kthSmallest(root.right, k - c - 1); 
        }
    }
    
    private int countNodes(TreeNode t) {
        if(t == null) {
            return 0; 
        }
        
        int l = (t.left == null) ? 0 : countNodes(t.left); 
        int r = (t.right == null) ? 0 : countNodes(t.right);
        
        return (l + r + 1); 
    }
}