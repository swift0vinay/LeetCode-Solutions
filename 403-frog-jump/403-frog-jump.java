class Solution {
    HashMap<Integer,Integer> hm;
    HashMap<String,Boolean> vis;
    int target;
    public boolean canCross(int[] ar) {
        target=ar.length-1;
        hm=new HashMap<>();
        vis=new HashMap<>();
        for(int i=0;i<ar.length;i++){
            hm.put(ar[i],i);
        }
        return dfs(0,0,ar);
    }
    boolean ans=false;
    boolean dfs(int start,int jump,int[] ar){
        if(ans)
            return true;
        if(jump<0)
            return false;
        // System.out.println(start+" "+jump);
        if(start==target){
            ans=true;
            return true;
        }
        if(vis.containsKey(start+":"+jump)){
            return vis.get(start+":"+jump);
        }
        if(start!=0 && jump==0)
            return false;
        boolean a=false,b=false,c=false;
        if(hm.get(ar[start]+jump-1)!=null){
            a=dfs(hm.get(ar[start]+jump-1),jump-1,ar);
        }
        if(jump!=0 && hm.get(ar[start]+jump)!=null){
            b=dfs(hm.get(ar[start]+jump),jump,ar);
        }
        if(hm.get(ar[start]+jump+1)!=null){
            c=dfs(hm.get(ar[start]+jump+1),jump+1,ar);
        }
        vis.put(start+":"+jump,(a||b||c));
        return a||b||c;
    }
}