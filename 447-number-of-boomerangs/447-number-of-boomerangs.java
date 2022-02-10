class Solution {
    public int numberOfBoomerangs(int[][] ar) {
          
        int n=ar.length;
        int ans=0;
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer>  hm=new HashMap<>();
             for(int j=0;j<n;j++){
                if(j!=i){
                    int a=Math.abs(ar[i][0]-ar[j][0]);
                    int b=Math.abs(ar[i][1]-ar[j][1]);
                int dist=a*a+b*b;
                if(hm.get(dist)==null){
                    hm.put(dist,1);
                }else{
                    hm.put(dist,hm.get(dist)+1);
                    }
                }
            }  
            Set<Integer> set=hm.keySet();
            for(Integer a:set){
               int val=hm.get(a);
                val=(val*(val-1));
                ans+=val;   
            }
        }
         
        return ans;
    }
}