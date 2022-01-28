class Solution {
    public String shortestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		String rev = new StringBuilder(s).reverse().toString();
		String z = s + ":" + rev;
		int[] lps = computeLps(z);
		int length = lps[lps.length - 1];
		String k = length  < s.length() ? s.substring(length , s.length()) : "";
		k=new StringBuilder(k).reverse().toString();
		return k + s;
	}

    int[] computeLps(String s) {
		int n = s.length();
		int[] lps = new int[n];
		int i = 1, len = 0;
		while (i < n) {
			if (s.charAt(i) == s.charAt(len)) {
				++len;
				lps[i] = len;
				++i;
			} else {
				if (len == 0)
					++i;
				else
					len = lps[len - 1];
			}
		}
		return lps;
	}
    
    boolean check(String s, int end) {
		int start = 0;
		while (start <= end) {
			if (s.charAt(end) != s.charAt(start)) {
				return false;
			}
			++start;
			--end;
		}
		return true;
	}
}