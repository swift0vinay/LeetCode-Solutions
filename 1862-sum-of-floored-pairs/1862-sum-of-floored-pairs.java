class Solution {
    public int sumOfFlooredPairs(int[] ar) {
		int N = (int) 1e5 + 1;
		long INF = (long) 1e9 + 7;
		long dp[] = new long[N];
		for (int i : ar)
			dp[i]++;
		for (int i = 1; i < N; i++) {
			dp[i] += dp[i - 1];
		}
		long ans = 0;
		for (int i = 1; i < N; i++) {
			if (dp[i] - dp[i - 1] > 0) {
				long sum = 0;
				for (int j = 1; j * i < N; j++) {
					int low = i * j;
					int high = Integer.min(i * (j + 1) - 1, N - 1);
					long count = dp[high] - dp[low - 1];
					sum = (sum + (count * j) % INF) % INF;
				}
				long z = dp[i] - dp[i - 1];
				ans = (ans + (z * sum) % INF) % INF;
			}
		}
	    return (int)ans;
    }}