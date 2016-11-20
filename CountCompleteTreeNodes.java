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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = getHeight(root);
        if (h == 1) {
            return 1;
        }
        int hRight = getHeight(root.right);
        if (hRight == h - 1) {
            return (1 << h - 1) + countNodes(root.right);
        } else {
            return (1 << h - 2) + countNodes(root.left);
        }
    }

    private int getHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
}