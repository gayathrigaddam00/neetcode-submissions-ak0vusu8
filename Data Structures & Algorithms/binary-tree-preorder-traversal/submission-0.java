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
class Solution {
    private List<Integer> ls;
    public List<Integer> preorderTraversal(TreeNode root) {
        ls=new ArrayList<>();
        preorder(root);
        return ls;
    }
    public void preorder(TreeNode node){
        if(node ==null){return;}
        ls.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }
}