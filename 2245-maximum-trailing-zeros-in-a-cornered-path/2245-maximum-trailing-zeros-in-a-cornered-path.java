class Solution {
    public int maxTrailingZeros(int[][] ar) {
		int n = ar.length, m = ar[0].length;
		int dp1[][][] = new int[n][m][3];
		int dp2[][][] = new int[n][m][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = ar[i][j];
				if (j - 1 >= 0) {
					for (int l = 0; l < 3; l++) {
						dp1[i][j][l] += dp1[i][j - 1][l];
					}
				}
				while (x % 10 == 0) {
					dp1[i][j][0] += 1;
					x /= 10;
				}
				while (x % 2 == 0) {
					dp1[i][j][1] += 1;
					x /= 2;
				}
				while (x % 5 == 0) {
					dp1[i][j][2] += 1;
					x /= 5;
				}
			}
		}
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				int x = ar[i][j];
				if (i - 1 >= 0) {
					for (int l = 0; l < 3; l++) {
						dp2[i][j][l] += dp2[i - 1][j][l];
					}
				}
				while (x % 10 == 0) {
					dp2[i][j][0] += 1;
					x /= 10;
				}
				while (x % 2 == 0) {
					dp2[i][j][1] += 1;
					x /= 2;
				}
				while (x % 5 == 0) {
					dp2[i][j][2] += 1;
					x /= 5;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int twos = 0, fives = 0, tens = 0;
				int x = ar[i][j];
				while (x % 10 == 0) {
					++tens;
					x /= 10;
				}
				while (x % 2 == 0) {
					++twos;
					x /= 2;
				}
				while (x % 5 == 0) {
					++fives;
					x /= 5;
				}
				int tt = dp1[i][j][1] + dp2[i][j][1] - twos;
				int tf = dp1[i][j][2] + dp2[i][j][2] - fives;
				int tT = dp1[i][j][0] + dp2[i][j][0] - tens;
				int cc = tT + Integer.min(tt, tf);
				max = Integer.max(max, cc);
				tt = dp2[i][j][1] + (j - 1 >= 0 ? dp1[i][m - 1][1] - dp1[i][j - 1][1] : dp1[i][m - 1][1]) - twos;
				tf = dp2[i][j][2] + (j - 1 >= 0 ? dp1[i][m - 1][2] - dp1[i][j - 1][2] : dp1[i][m - 1][2]) - fives;
				tT = dp2[i][j][0] + (j - 1 >= 0 ? dp1[i][m - 1][0] - dp1[i][j - 1][0] : dp1[i][m - 1][0]) - tens;
				cc = tT + Integer.min(tt, tf);
				max = Integer.max(max, cc);
				tt = (i - 1 >= 0 ? dp2[n - 1][j][1] - dp2[i - 1][j][1] : dp2[n - 1][j][1])
						+ (j - 1 >= 0 ? dp1[i][m - 1][1] - dp1[i][j - 1][1] : dp1[i][m - 1][1]) - twos;
				tf = (i - 1 >= 0 ? dp2[n - 1][j][2] - dp2[i - 1][j][2] : dp2[n - 1][j][2])
						+ (j - 1 >= 0 ? dp1[i][m - 1][2] - dp1[i][j - 1][2] : dp1[i][m - 1][2]) - fives;
				tT = (i - 1 >= 0 ? dp2[n - 1][j][0] - dp2[i - 1][j][0] : dp2[n - 1][j][0])
						+ (j - 1 >= 0 ? dp1[i][m - 1][0] - dp1[i][j - 1][0] : dp1[i][m - 1][0]) - tens;

				cc = tT + Integer.min(tt, tf);
				max = Integer.max(max, cc);
				tt = (i - 1 >= 0 ? dp2[n - 1][j][1] - dp2[i - 1][j][1] : dp2[n - 1][j][1]) + (dp1[i][j][1]) - twos;
				tf = (i - 1 >= 0 ? dp2[n - 1][j][2] - dp2[i - 1][j][2] : dp2[n - 1][j][2]) + (dp1[i][j][2]) - fives;
				tT = (i - 1 >= 0 ? dp2[n - 1][j][0] - dp2[i - 1][j][0] : dp2[n - 1][j][0]) + (dp1[i][j][0]) - tens;

				cc = tT + Integer.min(tt, tf);
				max = Integer.max(max, cc);

			}
		}
		return max;
	}
}