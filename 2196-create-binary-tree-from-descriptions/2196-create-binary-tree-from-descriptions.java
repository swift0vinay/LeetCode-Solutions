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
    HashMap<Integer,TreeNode> map=new HashMap<>();
    public TreeNode createBinaryTree(int[][] des) {
        HashSet<Integer> childs=new HashSet<>();
        for(int[] x:des){
            int parent=x[0],child=x[1],left=x[2];
            if(map.get(parent)==null){
                map.put(parent,new TreeNode(parent));
            }
            if(map.get(child)==null){
                map.put(child,new TreeNode(child));
            }
            childs.add(child);
            if(left==1){
                map.get(parent).left=map.get(child);
            }   
            else
                map.get(parent).right=map.get(child);
        }
        for(Integer z:map.keySet()){
            if(!childs.contains(z))
                return map.get(z);
        }
        return null;
    }
}