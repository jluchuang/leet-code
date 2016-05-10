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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

	    if(root == null) { 
	        return res; 
	    }

	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root); 
        TreeNode cur = root.left;
	    while(true) {
	        
	        if(stack.empty() && cur == null){
	            break;
	        }

	        if(cur != null) {
	            stack.push(cur);
		        cur = cur.left;
	        }
	        else {
	            cur = stack.pop();
	            res.add(cur.val);
		        cur = cur.right;
	        }

	    }
	    
	    return res;
    }
}