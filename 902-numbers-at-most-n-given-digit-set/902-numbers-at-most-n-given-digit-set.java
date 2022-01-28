class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
		int length = (n + "").length();
		boolean dp[] = new boolean[10];
		for (String z : digits) {
			dp[z.charAt(0) - '0'] = true;
		}
		int curr = 1;
		int ans = 0;
		while (curr < length) {
			ans += (int) Math.pow(digits.length, curr);
			++curr;
		}
		char ar[] = (n + "").toCharArray();
		ans+=cal(digits,ar,0);
        boolean g=true;
        for(int i=0;i<ar.length;i++){
            g=g&&(dp[ar[i]-'0']);
        }
        if(g)
            ++ans;
		return ans;
	}
    int cal(String[] digits,char[] ar,int index){
        int ans=0;
        if(index==ar.length)
            return 0;
        int curr=ar[index]-'0';
        for(int j=0;j<digits.length;j++){
            int d=digits[j].charAt(0)-'0';
            if(d<curr){
                ans+=(int)Math.pow(digits.length,ar.length-index-1);
            }else if(d==curr){
                ans+=cal(digits,ar,index+1);
            }else{
                break;
            }
        }
        return ans;
    }
}