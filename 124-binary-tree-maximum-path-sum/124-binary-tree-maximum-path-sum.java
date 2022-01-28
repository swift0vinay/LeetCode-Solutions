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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        max=Integer.max(max,root.val);
        max=Integer.max(max,left+right+root.val);
        max=Integer.max(max,Integer.max(root.val+left,root.val+right));
        return Integer.max(root.val,Integer.max(root.val+left,root.val+right));
    }
}