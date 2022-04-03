class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> al1=new ArrayList<>(),al2=new ArrayList<>();
        int win[]=new int[(int)1e5+1];
        int lose[]=new int[(int)1e5+1];
        int m[]=new int[(int)1e5+1];
        for(int[] x:matches){
            win[x[0]]+=1;
            lose[x[1]]+=1;
            m[x[0]]+=1;
            m[x[1]]+=1;
        }
        for(int i=1;i<win.length;i++){
            if(win[i]==m[i] && m[i]!=0){
                al1.add(i);
            }else if(lose[i]==1 && win[i]+lose[i]==m[i] && m[i]!=0){
                al2.add(i);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(al1);
        ans.add(al2);
        return ans;
    }
}