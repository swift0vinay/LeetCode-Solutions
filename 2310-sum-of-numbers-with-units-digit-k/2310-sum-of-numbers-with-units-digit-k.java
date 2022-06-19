class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int x = k;
        while (!set.contains(x%10)) {
            set.add(x%10);
            x+=k;
        }
        if (!set.contains(num%10)) {
            return -1;
        }
        set.clear();
        for (int i=0; i<3001; i++) {
           set.add(i*10+k);
        }
        int dp[] = new int[num+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=0; i<dp.length;i++){
            if(i==k){
                dp[i]=1;
            }else{  
                for(Integer z : set){
                    int rem = i-z;
                    if(rem==0){
                        dp[i]=Integer.min(dp[i],1);
                    }else if(rem>=0 && dp[rem] != Integer.MAX_VALUE && dp[rem]>0) {
                        dp[i]=Integer.min(dp[i], dp[rem]+1);
                    }
                }    
            }
        }
        // System.out.println(set);
        // System.out.println(Arrays.toString(dp));
        return dp[num] == Integer.MAX_VALUE?-1:dp[num];
    }
}