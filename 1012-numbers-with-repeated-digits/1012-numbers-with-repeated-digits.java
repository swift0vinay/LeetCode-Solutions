class Solution {
    public int numDupDigitsAtMostN(int N) {
        int length=(N+"").length();
        int ans=0;
        for(int i=1;i<length;i++){
            if(i==1)
                ans+=9;
            else if(i==2)
                ans+=81;
            else {
                int t=81;
                int z=i-2;
                int c=8;
                while(z>0){
                    t*=c;
                    --z;
                    --c;
                }
                ans+=t;
            }
        }
        char ar[]=(N+"").toCharArray();
        ans+=cal(ar,0);
        Arrays.sort(ar);
        boolean rs=true;
        for(int j=1;j<ar.length;j++){
            if(ar[j]==ar[j-1]){
                rs=false;
                break;
            }
        }
        if(rs)
            ++ans;
        return N-ans;
    }
    boolean dp[]=new boolean[10];
    int cal(char[] ar,int index){
		if (index == ar.length)
			return 0;
		int currDigit = ar[index] - '0';
		int ans = 0;
		for (int digit = 0; digit < 10; digit++) {
			if (index == 0 && digit == 0)
				continue;
			if (digit < currDigit) {
				if (dp[digit]) {
					continue;
				}
				int left = 10 - index;
				int j = index + 1;
				int u = 0;
				for (int i = 0; i < currDigit; i++) {
					if (!dp[i])
						++u;
				}
				int temp = index + 1 < ar.length ? 1 : 1;
				while (j < ar.length) {
					--left;
					temp *= left;
					++j;
				}
				ans += temp;
			} else if (digit == currDigit) {
				dp[digit] = true;
				if (index + 1 < ar.length && dp[ar[index + 1] - '0']) {
        			int curr = 10 - index - 1;
					int usable = 0;
					for (int i = 0; i < ar[index + 1] - '0'; i++) {
						if (!dp[i]) {
							usable++;
						}
					}
					int temp = usable;
					--curr;
					int j = index + 2;
					while (j < ar.length) {
						temp *= curr;
						++j;
						--curr;
					}
					ans += temp;
					break;
				} else {
					ans += cal(ar, index + 1);
				}
			} else {
				break;
			}
        }
		return ans;
	}
}