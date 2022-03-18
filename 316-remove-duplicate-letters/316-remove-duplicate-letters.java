class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
		Stack<Character> st = new Stack<Character>();
		Stack<Integer> st2 = new Stack<Integer>();
		char ar[] = s.toCharArray();
		int li[] = new int[26];
		Arrays.fill(li, -1);
		for (int i = 0; i < n; i++) {
			char ch = ar[i];
			int index = ch - 'a';
			li[index] = i;
		}
		boolean visited[] = new boolean[26];

		for (int i = 0; i < n; i++) {
			char ch = ar[i];
			int index = ar[i] - 'a';
			if (st.isEmpty()) {
				st.add(ch);
				st2.add(i);
				visited[index] = true;
			} else {
					if (visited[index]) {
					for (int a = 0; a < st.size(); a++) {
						if (st.get(a) == ch) {
							st2.set(a, i);
							break;
						}
					}
					continue;
				}
			
				while (st.peek() > ch) {
					char peek = st.peek();
					int peekIndex = peek - 'a';
					int lastPeekIndex = li[peekIndex];
					int pushedIndex = st2.peek();
					if (lastPeekIndex == pushedIndex) {
						break;
					} else {
						st.pop();
						st2.pop();
						visited[peekIndex] = false;
					}
					if (st.isEmpty()) {
						break;
					}
				}
				st.add(ch);
				st2.add(i);
				visited[index] = true;
			}
		}
		StringBuilder ans = new StringBuilder();
		while (!st.isEmpty()) {
			ans.append(st.pop());
		}
		return ans.reverse().toString();
    }
}