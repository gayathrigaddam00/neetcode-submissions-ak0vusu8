/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("N,");
            }else{
                res.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty()) return null;
        String[] tokens = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty() && i<tokens.length){
            TreeNode node = q.poll();
            if(!tokens[i].equals("N")){
                node.left = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(node.left);
            }
            i++;
            if(i<tokens.length && !tokens[i].equals("N")){
                node.right = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
