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
    HashMap<Integer,ArrayList<Pair>> hm;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        hm=new HashMap<>();
        dfs(root,0,0);
        ArrayList<Integer> al=new ArrayList<>();
        al.addAll(hm.keySet());
        Collections.sort(al);
        List<List<Integer>> ans=new ArrayList<>();
        for(Integer z:al){
            List<Pair> temp=new ArrayList<>();
            temp.addAll(hm.get(z));
            Collections.sort(temp,(a,b)->a.x==b.x?a.val-b.val:a.x-b.x);
            List<Integer> t=new ArrayList<>();
            for(Pair pp:temp)
                t.add(pp.val);
            ans.add(t);
        }
        return ans;
    }
    
    class Pair{
        int x,val;
        Pair(int x,int val){
            this.x=x;
            this.val=val;
        }
    }
    
    void dfs(TreeNode root,int x,int y){
        if(root==null)
            return ;
        if(hm.get(y)==null){
            hm.put(y,new ArrayList<Pair>());
        }
        hm.get(y).add(new Pair(x,root.val));
        dfs(root.left,x+1,y-1);
        dfs(root.right,x+1,y+1);
    }
}