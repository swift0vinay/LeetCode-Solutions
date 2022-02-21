class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int dp[]=new int[26];
        for(char x:s.toCharArray()) dp[x-'a']++;
        for(int i=0;i<26;i++){
            if(dp[i]>0){
                pq.add(new int[]{i,dp[i]});
            }
        }
        int prev=-1;
        StringBuilder ans=new StringBuilder();
        while(pq.size()>1){
            int[] ss=pq.poll();
            if(ss[0]==prev){
                int[] p=pq.poll();
                pq.add(ss);
                ss=p;
                ans.append(((char)(ss[0]+'a')));
                ss[1]-=1;
                prev=ss[0];
                if(ss[1]>0){
                    pq.add(new int[]{ss[0],ss[1]});
                }
            }else{
                int z=Integer.min(repeatLimit,ss[1]);
                ans.append((((char)(ss[0]+'a'))+"").repeat(z));
                ss[1]-=z;
                prev=ss[0];
                if(ss[1]>0){
                    pq.add(new int[]{ss[0],ss[1]});
                }
            }
            
        }
        if(pq.peek()[0]!=prev){
            int[] ss=pq.poll();
            int z=Integer.min(repeatLimit,ss[1]);
            ans.append((((char)(ss[0]+'a'))+"").repeat(z)); 
        } 
        return ans.toString();
    }
}