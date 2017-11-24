  public boolean canMerge(String a, String b, String c) {
    int alen = a.length();
    int blen = b.length();
    boolean[][] dp = new boolean[alen+1][blen + 1];
    if (alen + blen != c.length()) return false; 
    for (int i = 0; i <= alen; i++) {
      for (int j = 0; j <= blen; j++) {
        if (i == 0 && j == 0) dp[i][j] = true;
        if (i > 0 && a.charAt(i - 1) == c.charAt(i - 1 + j)) {
          dp[i][j] = dp[i-1][j];
        }
        if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
          dp[i][j] = dp[i][j] || dp[i][j-1];
        }
      }
    }
    return dp[alen][blen];
  }
