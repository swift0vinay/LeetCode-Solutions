class Solution {
    public String minWindow(String s, String t) {
		ArrayList<Pair> al=new ArrayList<>();
        int dp[]=new int[256],curr[]=new int[256];
        for(char x:t.toCharArray()){
            dp[x]++;
        }
        for(int i=0;i<s.length();i++){
            if(dp[s.charAt(i)]>0)
                al.add(new Pair(s.charAt(i),i));
        }
        int start=0,end=0;
        int min=Integer.MAX_VALUE;
        int finalStart=-1,finalEnd=-1;
        while(end<al.size()){
            char x=al.get(end).item;
            curr[x]++;
            if(check(curr,dp)){
                while(start<end && curr[al.get(start).item]>dp[al.get(start).item]){
                    x=al.get(start).item;
                    --curr[x];
                    ++start;
                }
                int length=al.get(end).index-al.get(start).index+1;
                if(length<min){
                    finalStart=al.get(start).index;
                    finalEnd=al.get(end).index;
                    min=length;
                }
                while(start<end && check(curr,dp)){
                    x=al.get(start).item;
                    --curr[x];
                    ++start;
                }
            }
            ++end;
        }
        return min==Integer.MAX_VALUE?"":s.substring(finalStart,finalEnd+1);
	}
    
    class Pair{
        char item;
        int index;
        Pair(char item,int count){
            this.index=count;
            this.item=item;
        }
        public String toString(){
            return index+" "+item;
        }
    }
    
    boolean check(int[] dp1,int[] dp2){
        for(int i=0;i<dp1.length;i++){
            if(dp1[i]<dp2[i])
                return false;
        }
        return true;
    }
}