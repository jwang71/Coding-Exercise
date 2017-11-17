  public int maxProduct(int length) {
    int[] dp = new int[length + 1];
    dp[1] = 1;
    dp[2] = 1;
    
    for (int i = 3; i <= length; i++) {
      for (int j = 1; j < i; j++) {
        dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
      }
    }
    return dp[length];
  }