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
    int max=0;
    public int maxSumBST(TreeNode root) {
        post(root);
        return max;
    }
    int MIN=Integer.MIN_VALUE;
    int MAX=Integer.MAX_VALUE;
    int[] post(TreeNode root){
        if(root==null) return new int[]{MAX,MIN,0};
        int left[]=post(root.left);
        int right[]=post(root.right);
        if(!(left!=null && right!=null && left[1]<root.val && root.val<right[0])){
            return null;
        }
        int sum=root.val+left[2]+right[2];
        max=Integer.max(max,sum);
        int min=Integer.min(left[0],root.val);
        int max=Integer.max(right[1],root.val);
        return new int[]{min,max,sum};
    }
}