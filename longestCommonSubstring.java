  public String longestCommon(String s, String t) {
    if (s == null || t == null) return "";
    char[] sarray = s.toCharArray();
    char[] tarray = t.toCharArray();
    
    int m = s.length();
    int n = t.length();
    int[][] dp = new int[m][n];
    int max = 0;
    int start = 0;
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (sarray[i] == tarray[j]) {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = dp[i-1][j-1] + 1;
          }
        }
        if (dp[i][j] > max) {
          max = dp[i][j];
          start = i - max + 1;
        }
      }
    }
    return s.substring(start, start + max);
  }
