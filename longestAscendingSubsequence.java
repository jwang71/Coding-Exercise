  public int longest(int[] array) {
    if (array.length == 0) return 0;
    int[] dp = new int[array.length];
    dp[0] = 1;
    int max = 1;
    
    for (int i = 1; i < array.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (array[j] < array[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(dp[i], max);
    }
    return max;
  }