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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inOrder = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrder.put(inorder[i],i); 

            
        }
        return splitTree(preorder,inOrder,0,0,inorder.length-1);
    }
        private TreeNode splitTree(int[] preorder,Map<Integer,Integer> inOrder,int rootIndex,int left,int right){
            TreeNode root = new TreeNode(preorder[rootIndex]);
            int mid=inOrder.get(preorder[rootIndex]);
            if(mid>left){
                root.left=splitTree(preorder,inOrder,rootIndex+1,left,mid-1);
            }
            if(mid<right){
                root.right=splitTree(preorder,inOrder,rootIndex+mid-left+1,mid+1,right);
            }
            return root;
        }

    
}