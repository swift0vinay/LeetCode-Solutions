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
    Map<Integer,List<TreeNode>> hm = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!hm.containsKey(n)){
            List<TreeNode> ans = new LinkedList<>();
            if(n==1){
                ans.add(new TreeNode(0));
            }else if(n%2==1){
                for(int i=0;i<n;i++){
                    int j = n-i-1;
                    for(TreeNode left : allPossibleFBT(i)){
                        for(TreeNode right : allPossibleFBT(j)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                    }
                }
            }
            hm.put(n,ans);
        }
        return hm.get(n);
    }
}