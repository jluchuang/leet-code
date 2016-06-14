/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack <TreeNode> stack; 
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>(); 
        setNext(root); 
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty(); 
    }

    /** @return the next smallest number */
    public int next() {
        if(stack.empty()) {
            return -1; 
        }
        
        TreeNode cur = stack.pop();
        setNext(cur.right);
        
        return cur.val;
    }
    
    private void setNext(TreeNode currentRight) {
        while (currentRight != null) {
            stack.push(currentRight); 
            currentRight = currentRight.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */