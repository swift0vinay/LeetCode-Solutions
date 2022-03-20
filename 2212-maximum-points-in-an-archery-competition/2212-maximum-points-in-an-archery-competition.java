class Solution {
    public int[] maximumBobPoints(int n, int[] A) {
		int total = (1 << 12);
		int ans[] = new int[12];
		int max = 0;
		for (int i = 1; i < total; i++) {
			String b = Integer.toBinaryString(i);
			while (b.length() < 12) {
				b = "0" + b;
			}
			char[] br = b.toCharArray();
			int B[] = new int[12];
			int reqd = 0;
			int have = n;
			for(int ii=11;ii>=0;ii--){
                if(br[ii]=='1'){
                    reqd+=(A[ii]+1);
                }
            }
            if(reqd>have){
                continue;
            }
			int score = 0;
			for (int ii = 0; ii < 12; ii++) {
                if(br[ii]=='1')
                    B[ii]=A[ii]+1;
				if (B[ii] > A[ii]) {
					score += ii;
				}
			}
			if (score > max) {
				max = score;
				ans = B;
			}
		}
        // System.out.println(Arrays.toString(ans));
        int done = 0;
		for (int x : ans)
			done += x;
		int left = n - done;
		ans[0] += left;
		return ans;
	}
}