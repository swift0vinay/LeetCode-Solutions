class Solution {
    public List<List<Integer>> findSubsequences(int[] ar) {
		int n = ar.length;
		int total = (int) Math.pow(2, n);
		List<List<Integer>> list = new ArrayList<>();
		HashSet<String> set = new HashSet<String>();
		int ans = 0;
		for (int i = 1; i < total; i++) {
			if (Integer.bitCount(i) >= 2) {
				char b[] = Integer.toBinaryString(i).toCharArray();
				List<Integer> temp = new ArrayList<Integer>();
				int end = ar.length - 1;
				StringBuilder ss = new StringBuilder();
				for (int j = b.length - 1; j >= 0; j--) {
					if (b[j] == '1') {
						temp.add(ar[end]);
						ss.append(ar[end]);
					}
					--end;
				}
				boolean rs = true;
				for (int j = 0; j < temp.size() - 1; j++) {
					if (temp.get(j) < temp.get(j + 1)) {
						rs = false;
						break;
					}
				}
				if (rs) {
					++ans;
					Collections.reverse(temp);
					ss.reverse();
					rs = true;
					if (!set.contains(ss.toString())) {
						set.add(ss.toString());
						list.add(temp);
					}

				}
			}
		}
		return list;
	}
}