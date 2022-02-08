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
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,null);
        return sum;
    }
    void dfs(TreeNode root,Boolean d){
        if(root==null)
            return;
        if(d!=null && d && root.left==null && root.right==null)
            sum+=root.val;
        dfs(root.left,true);
        dfs(root.right,false);
    }
}