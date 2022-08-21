class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int dp[]=new int[n+1];
        for(int i=0;i<shifts.length;i++){
            int l=shifts[i][0],r=shifts[i][1],d=shifts[i][2];
            dp[l]+=(d==0)?-1:1;
            dp[r+1]+=(d==0)?1:-1;
        }
        int sum=0;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            sum+=dp[i];
            int c=(s.charAt(i)-'a')+sum;
            c%=26;
            if(c<0)
                c+=26;
            ans.append((char)(c+'a'));
        }
        return ans.toString();
    }
}