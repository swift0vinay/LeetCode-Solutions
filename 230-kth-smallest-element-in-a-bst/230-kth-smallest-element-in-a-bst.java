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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        dfs(root,pq,k);
        while(k-1>0)
        {
            pq.poll();
            --k;
        }
        return pq.poll();
    }
    void dfs(TreeNode node,PriorityQueue<Integer> pq,int k){
        pq.add(node.val);
        if(node.left!=null)
            dfs(node.left,pq,k);
        if(node.right!=null)
            dfs(node.right,pq,k);
    }    
}