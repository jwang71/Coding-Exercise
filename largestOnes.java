  public int longest(int[] array) {
    if (array == null || array.length == 0) return 0;
    int[] dp = new int[array.length];
    dp[0] = array[0] == 1 ? 1 : 0;
    int max = dp[0];
    
    for (int i = 1; i < array.length; i++) {
      if (array[i] == 1) {
        dp[i] = dp[i-1] + 1;
      } else {
        dp[i] = 0;
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }