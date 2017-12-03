  public String removeSpaces(String input) {
    if (input == null || input.length() == 0) return input;
    
    int i = 0;
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    
    while (i < input.length()) {
      if (input.charAt(i) == ' ') {
        i++;
      } else {
        int start = i;
        while (i < input.length() && input.charAt(i) != ' ') {
          i++;
        }
        if (first) {
          sb.append(input.substring(start, i));
          first = false;
        } else {
          sb.append(' ').append(input.substring(start, i));
        }
      }
    }
    return sb.toString();
  }