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
    public int diameterOfBinaryTree(TreeNode root) {

        postorder(root);

        return diameter;
        
    }

    int diameter=0;

    int postorder(TreeNode node){
        if(node==null) return 0;

        int ls=postorder(node.left);
        int rs=postorder(node.right);

        diameter=Math.max(diameter, ls+rs);

        return Math.max(ls,rs)+1;
    }
}