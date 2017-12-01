  public String decompress(String input) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int n = input.length();
    
    while (i < input.length()) {
      if (i == n - 1 && Character.isLetter(input.charAt(i))) {
        sb.append(input.charAt(i));
        i++;
      }
      if (i + 1 < n && Character.isLetter(input.charAt(i+1))) {
        sb.append(input.charAt(i));
        i++;
      }
      if (i + 1 < n && Character.isDigit(input.charAt(i + 1))) {
        char c = input.charAt(i);
        int j = i + 1;
        int number = 0;
        while (j < n && Character.isDigit(input.charAt(j))) {
          number = 10 * number + input.charAt(j) - '0';
          j++;
        }
        for (int k = 0; k < number; k++) {
          sb.append(c);
        }
        i = j;
      }
    }
    return sb.toString();
  }
