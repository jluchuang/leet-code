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
        Stack<Integer> colorSt = new Stack<Integer>();
        stack.push(root);
        colorSt.push(1);
        
        TreeNode cur = root.left; 
        Integer curCol = 1; 
        while(true) {
            
            if(cur == null && stack.empty()){
                break;
            }
            
            if(cur != null && curCol == 1) {
                stack.push(cur);
                colorSt.push(1);
                cur = cur.left;
            }
            else {
                if(curCol == 2) {
                    res.add(cur.val);
                }
                if(stack.empty()) {
                    break;
                }
                cur = stack.pop();
                curCol = colorSt.pop();
                if(curCol == 1) {
                    stack.push(cur);
                    colorSt.push(2);
                    cur = cur.right;
                    curCol = 1;
                }
            }
        }
        return res;
    }
}