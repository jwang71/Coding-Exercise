  public boolean canJump(int[] array) {
    int n = array.length;
    boolean[] dp = new boolean[n];
    
    dp[n - 1] = true;
    
    for (int i = n - 2; i >= 0; i--) {
      if (i + array[i] >= n - 1) {
        dp[i] = true;
        continue;
      }
      for (int j = i; j <= i + array[i]; j++) {
        if (dp[j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[0];
  }