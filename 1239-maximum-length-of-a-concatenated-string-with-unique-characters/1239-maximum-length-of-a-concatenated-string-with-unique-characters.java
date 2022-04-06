class Solution {
    public int maxLength(List<String> arr) {
        int ans=0;
        int total=arr.size();
        for(int i=1;i<(1<<total);i++){
            int dp[]=new int[26];
            int tl=0;
            int len=arr.size()-1;
            for(int j=0;j<32;j++){
                int k=i>>j;
                if((k&1)==1){
                    tl+=arr.get(len).length();
                    for(int l=0;l<arr.get(len).length();l++){
                        dp[arr.get(len).charAt(l)-'a']+=1;
                    }
                }
                --len;
                if(len<0)
                    break;
            }
            boolean rs=true;
            for(int x:dp){
                if(x>1){
                    rs=false;
                    break;
                }
            }
            if(rs){
                ans=Integer.max(ans,tl);
            }
        }
        return ans;
    }
}