  public String longestPalindrome(String s) {
    int n = s.length() * 2;
    String res = "";
    for (int i = 0; i < n; i++) {
      int left = i/2;
      int right = i % 2 == 0 ? left : left + 1;
      
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      if (right - left - 1 > res.length()) {
        res = s.substring(left + 1, right);
      }
    }
    return res;
  }
