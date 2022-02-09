class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> al=new ArrayList<>();
        if(p.length()>s.length())
            return al;
        char ar[]=s.toCharArray();
        int dp[]=new int[26];
        for(char x:p.toCharArray()){
            dp[x-'a']++;
        }
        int curr[]=new int[26];
        int len=p.length();
        for(int i=0;i<len;i++){
            curr[ar[i]-'a']++;
        }
        if(check(curr,dp)){
            al.add(0);
        }
        int start=0;
        for(int j=len;j<ar.length;j++){
            --curr[ar[start]-'a'];
            ++curr[ar[j]-'a'];
            ++start;
            if(check(curr,dp)){
                al.add(start);
            }
        }
        return al;
    }
    boolean check(int[] curr,int[] dp){
        for(int i=0;i<26;i++){
            if(curr[i]!=dp[i])
                return false;
        }
        return true;
    }
}