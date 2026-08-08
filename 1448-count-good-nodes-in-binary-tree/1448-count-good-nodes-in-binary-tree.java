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
    public int goodNodes(TreeNode root) {

        return preorder(root, root.val);


        
    }

    public int preorder(TreeNode node, int max){

        int count=0;
        if(node==null){
            return 0;
        }

        if(node.val>=max) count++;

        max=Math.max(max, node.val);

        count+=preorder(node.left,max);
        count+=preorder(node.right,max);

        return count;



    }
}