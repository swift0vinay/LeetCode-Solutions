class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        ArrayDeque<int[]> dq=new ArrayDeque<>();
        for(int min=0;min<=99;min++){
            int sec=targetSeconds-min*60;
            if(sec>=0 && sec<=99){
                dq.add(new int[]{min,sec});
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int[] s:dq){
            String a=s[0]+"",b=s[1]+"";
            if(a.length()==1){
                if(a.charAt(0)=='0'){
                    if(b.length()!=2){
                        if(s[1]==0)
                            b="";
                    }
                }else{
                    while(b.length()!=2)
                        b="0"+b;
                }
            }else{
                while(b.length()!=2)
                        b="0"+b;
            }
            String ss=(s[0]==0?"":a)+b;
            int start=startAt;
            int cost=0;
            int ind=0;
            while(ind<ss.length()){
                if(start==(ss.charAt(ind)-'0')){
                    cost+=pushCost;
                    ++ind;
                }else{
                    cost+=moveCost;
                    cost+=pushCost;
                    start=ss.charAt(ind)-'0';
                    ++ind;
                }
            }
            ans=Integer.min(ans,cost);
        }
        return ans;
    }
}