class Solution {
    public int minOperations(int[] target, int[] ar) {
		int n = target.length;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++)
			hm.put(target[i], i);
		int max = 0;
		n = ar.length;
		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = hm.getOrDefault(ar[i], -1);
		}
		Arrays.fill(dp, Integer.MAX_VALUE);
		int last = -1;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == -1)
				continue;
			if (last == -1) {
				dp[++last] = ar[i];
				max = Integer.max(max, last + 1);
			} else if (dp[last] < ar[i]) {
				dp[++last] = ar[i];
				max = Integer.max(max, last + 1);
			} else {
				int index = get(dp, ar[i]);
				if (index == -2)
					continue;
				dp[index] = ar[i];
			}
		}
		return target.length - max;
	}
    int get(int[] dp,int item){
		int start = 0, end = dp.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (dp[mid] == item) {
				return -2;
			}
			if (dp[mid] > item) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return end + 1;
	}
}