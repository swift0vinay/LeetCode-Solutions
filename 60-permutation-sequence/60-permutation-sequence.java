class Solution {
    int fact[]={0,1,2,6,24,120,720,5040,40320,362800};
    public String getPermutation(int n, int k) {
        boolean used[]=new boolean[n+1];
        return find(used,k,1,n);
    }
    String find(boolean[] used,int k,int index,int n){
        if(index==n){
            for(int i=1;i<used.length;i++){
                if(!used[i])
                    return i+"";
            }
        }
        int sum=0;
        int time=fact[n-index];
        int digit=-1;
        for(int i=1;i<used.length;i++){
            if(!used[i]){
                if(sum+time>=k){
                    used[i]=true;
                    digit=i;
                    break;
                }
                sum+=time;
            }
        }
        return digit+find(used,k-sum,index+1,n);
    }
}