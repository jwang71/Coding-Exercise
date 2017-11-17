  public int largestSum(int[] array) {
    int n = array.length;
    int[] dp = new int[n];
    dp[0] = array[0];
    int max = array[0];
    for (int i = 1; i < n; i++) {
      dp[i] = dp[i-1] < 0 ? array[i] : dp[i - 1] + array[i];
      max = Math.max(max, dp[i]);
    }
    return max;
  }