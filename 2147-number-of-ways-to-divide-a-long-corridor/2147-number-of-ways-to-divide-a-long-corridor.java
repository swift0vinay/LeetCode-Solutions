class Solution {
    public int numberOfWays(String ch) {
        char ar[]=ch.toCharArray();
        int total=0;
        long INF=(long)1e9+7;
        long ans=1;

        for(char x:ar){
            if(x=='S')
                ++total;
        }
        if(total==0|| total%2!=0)
            return 0;
        ArrayList<Integer> al=new ArrayList<>();
        int c=0,i=0;
        for(;i<ar.length;i++){
            if(ar[i]=='S')
                break;
        }
        int start=i;
        int end=start+1;
        while(end<ar.length){
            if(ar[end]=='S'){
                c=-1;
                do{
                    ++c;
                    ++end;
                }while((end<ar.length && ar[end]!='S'));
                if(c>0 && end!=ar.length){
                    ans=(ans*(c+1))%INF;
                }

                start=end;
                end=start;
            }
            ++end;
        }
        return (int)ans;
    }
}