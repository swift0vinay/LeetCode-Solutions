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
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int[] sum = {left[0]+right[0],left[1]+right[1]};
        sum[0]+=root.val;
        sum[1]+=1;
        if(sum[0]/sum[1] == root.val) {
            ++ans;
        }        
        return sum;
    }
}