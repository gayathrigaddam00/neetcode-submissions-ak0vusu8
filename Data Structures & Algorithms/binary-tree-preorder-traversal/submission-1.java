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
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr=root;

        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                ls.add(curr.val);
                st.push(curr.right);
                curr=curr.left;
            }else{
                curr=st.pop();
            }
        }
        return ls;
    }
}