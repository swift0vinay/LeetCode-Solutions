class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> ar) {
		int n = ar.size();
		int endPoint = -1;
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			if (ar.get(i).equals(endWord))
				endPoint = i;
			for (int j = i + 1; j < n; j++) {
				int c = 0;
				for (int k = 0; k < ar.get(0).length(); k++) {
					if (ar.get(i).charAt(k) != ar.get(j).charAt(k)) {
						++c;
					}
				}
				if (c == 1) {
					al.get(i).add(j);
					al.get(j).add(i);
				}
			}
		}
		HashSet<Integer> ss = new HashSet<Integer>();
		int ii = -1;
		for (int i = 0; i < n; i++) {
			int c = 0;
			for (int k = 0; k < ar.get(0).length(); k++) {
				if (beginWord.charAt(k) != ar.get(i).charAt(k)) {
					++c;
				}
			}
			if (c == 0) {
				ii = i;
			}
			if (c == 1) {
				ss.add(i);
			}
		}
		int ans = 0;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		boolean visited[] = new boolean[n];
		if (ii != -1)
			visited[ii] = true;
		dq.add(-1);
		int min = Integer.MAX_VALUE;
		while (!dq.isEmpty()) {
			int size = dq.size();
			for (int i = 0; i < size; i++) {
				int index = dq.pollFirst();
				if (index != -1 && ar.get(index).equals(endWord)) {
					min = ans + 1;
					break;
				}
				if (index == -1) {
					for (Integer z : ss) {
						if (!visited[z]) {
							visited[z] = true;
							dq.add(z);
						}
					}
				} else {
					for (Integer z : al.get(index)) {
						if (!visited[z]) {
							visited[z] = true;
							dq.add(z);
						}
					}
				}
			}
			++ans;
			if (min != Integer.MAX_VALUE)
				break;
		}
		List<List<String>> all = new ArrayList<>();
        if (min != Integer.MAX_VALUE) {
			visited = new boolean[n];
            ArrayList<String> temp=new ArrayList<>();
            temp.add(endWord);
			dfs(all,temp , visited, al, min-1, 0, endPoint, ar, ss,beginWord);
		}
        return all;
	}
        
    void dfs(List<List<String>> all, ArrayList<String> temp, boolean[] visited,
			ArrayList<ArrayList<Integer>> al, int min, int count, int src, List<String> ar, HashSet<Integer> ss,String startWord) {
		visited[src] = true;
		if (count == min-1) {
			if (ss.contains(src)) {
				ArrayList<String> aa=new ArrayList<>(temp);
                aa.add(startWord);
                Collections.reverse(aa);
                all.add(aa);
			}
			visited[src] = false;
			return;
		}
		for (Integer z : al.get(src)) {
			if (!visited[z]) {
				temp.add(ar.get(z));
				dfs(all, temp, visited, al, min, count + 1, z, ar, ss,startWord);
				temp.remove(temp.size() - 1);
			}
		}
		visited[src] = false;
	}
}