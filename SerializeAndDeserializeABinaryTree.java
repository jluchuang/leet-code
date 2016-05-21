/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null"; 
        }
        
        // BFS
        StringBuilder strB = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root); 
        
        while(q.size() != 0) {
            TreeNode tmp = q.poll(); 
            if(tmp != null) {
                strB.append(tmp.val); 
                q.add(tmp.left); 
                q.add(tmp.right); 
            }
            else {
                strB.append("null"); 
            }
            strB.append(","); 
        }
        
        String res = strB.substring(0, strB.length()-1); 
        
        return res; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        
        if(data.equals("null")) {
            return null; 
        }
        String[] nodes = data.split(","); 
        
        TreeNode res = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> row = new LinkedList<TreeNode>();
        row.add(res); 
        
        int pos = 1; 
        while(row.size() != 0) {
            TreeNode tmp = row.poll();
            if(tmp == null) {
                continue; 
            }
            else {
                
                if(nodes[pos].equals("null")) {
                    row.add(null); 
                }
                else {
                    tmp.left = new TreeNode(Integer.valueOf(nodes[pos])); 
                    row.add(tmp.left);
                }
                pos ++;
                
                if(nodes[pos].equals("null")) {
                    row.add(null); 
                }
                else {
                    tmp.right = new TreeNode(Integer.valueOf(nodes[pos])); 
                    row.add(tmp.right);
                }
                pos ++;
            }
        }
        
        return res; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));