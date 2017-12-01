  public String compress(String input) {
    StringBuilder sb = new StringBuilder();
    
    int n = input.length();
    for (int i = 0; i < n; i++) {
      char c = input.charAt(i);
      int j = i;
      while (j + 1 < n && input.charAt(j + 1) == c) {
        j++;
      }
      
      int count = j - i + 1;
      if (count == 1) {
        sb.append(c);
      } else {
        sb.append(c).append(count);
      }
      i = j;
    }
    return sb.toString();
  }