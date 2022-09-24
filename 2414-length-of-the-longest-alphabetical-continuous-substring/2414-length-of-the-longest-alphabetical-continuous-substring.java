class Solution {
    public int longestContinuousSubstring(String s) {
        char ar[] = s.toCharArray();
        int ans=0;
        for(int i=0;i<ar.length;){
                int j=i+1;
                int c=1;
                for(;j<ar.length;j++){
                    if((ar[j]-'a')-(ar[j-1]-'a')==1){
                        ++c;
                    }else{
                        break;
                    }
                }
                ans = Integer.max(ans, Integer.min(26,c));
                i=j;
        }
        return ans;
    }
}