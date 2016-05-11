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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root; 
        while (true) {
            if(cur != null) {
                if(cur.right != null) {
                    stack.push(cur.right); 
                }
                stack.push(cur);
                cur = cur.left; 
                continue;
            }
            
            if(stack.empty()) {
                break; 
            }
            
            cur = stack.pop();
            if(!stack.empty() && cur.right == stack.peek()) {
                stack.pop();
                stack.push(cur);
                cur = cur.right; 
            }
            else {
                res.add(cur.val);
                cur = null; 
            }
        }
        return res;
    }
}