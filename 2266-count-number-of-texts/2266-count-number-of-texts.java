class Solution {
    long mul(long a, long b) {
		return a * b % INF;
	}

	long fastPow(long base, long exp) {
		if (exp == 0)
			return 1;
		long half = fastPow(base, exp / 2);
		if (exp % 2 == 0)
			return mul(half, half);
		return mul(half, mul(half, base));
	}
    int get(int x){
        if(x==7||x==9)
            return 4;
        else
            return 3;
    }
    long INF=(long)1e9+7;
    public int countTexts(String s) {
        ArrayList<int[]> groups = new ArrayList<>();
        for(int i=0;i<s.length();){
            char x=s.charAt(i);
            int c=1, j=i+1;
            for(;j<s.length();j++){
                if(s.charAt(j)==x){
                    ++c;        
                }else{
                    break;
                }
            }
            groups.add(new int[]{x-'0',c});
            i=j;
        }
        long ans=1;
        for(int[] g:groups) {
            int id=g[0],cc=g[1];
            long temp=0;
            if(cc==1) {
                continue;
            }else if(cc==2) {
                ans=mul(ans,2);
                continue;
            }else if(cc==3) {
                ans=mul(ans,4);
                continue;
            }
            int get = get(id);
            if(get==4){
                if(cc==4){
                    ans=mul(ans,8);
                    continue;
                }
                long a=1,b=2,c=4,d=8;
                temp=a+b+c+d;
                for(int len=5;len<=cc;len++) {
                    temp=a+b+c+d;
                    temp%=INF;
                    a=b;
                    b=c;
                    c=d;
                    d=temp;
                }
            }else{
                long a=1,b=2,c=4;
                temp=a+b+c;
                for(int len=4;len<=cc;len++){
                    temp=a+b+c;
                    temp%=INF;
                    a=b;
                    b=c;
                    c=temp;
                }
            }
            ans=mul(ans,temp);
        }
        return (int)ans;
    }
}