  public boolean canBreak(String input, String[] dict) {
    HashSet<String> set = new HashSet<>();
    for (String s : dict) {
      if (s != null) {
        set.add(s);
      }
    }
    
    int n = input.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = set.contains(input.substring(0,1));
    
    for (int i = 1; i <= n; i++) {
      if (set.contains(input.substring(0, i))) {
        dp[i] = true;
        continue;
      }
      
      for (int j = 0; j <= i; j++) {
        if (dp[j] && set.contains(input.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }