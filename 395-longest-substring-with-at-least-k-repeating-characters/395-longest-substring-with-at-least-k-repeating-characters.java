class Solution {
    int ans=0;
    public int longestSubstring(String s, int k) {
        char ar[]=s.toCharArray();
        int n=ar.length;
        
        return solve(ar,0,ar.length,k);
    }
    
    int solve(char[] ar,int start,int end,int k){
         if(end<k){
             return 0;
         }
        int dp[]=new int[26];
        for(int i=start;i<end;i++){
            dp[ar[i]-'a']++;
        }
        for(int mid=start;mid<end;mid++){
            if(dp[ar[mid]-'a']>=k) continue;
            int mm=mid+1;
            while(mm<end&&dp[ar[mm]-'a']<k) mm++;
            return Math.max(solve(ar,start,mid,k),solve(ar,mm,end,k));
        }
        return end-start;
    }
}