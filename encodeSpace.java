
  public String encode(String input) {
    if (input == null || input.length() == 0) {
      return "";
    }
    int spaces = 0;
    char[] array = input.toCharArray();
    for (char c : array) {
      if (c == ' ') {
        spaces++;
      }
    }
    
    int newLength = input.length() + spaces*2;
    char[] res = new char[newLength];
    int slow = newLength - 1;
    
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] == ' ') {
        res[slow--] = '%';
        res[slow--] = '0';
        res[slow--] = '2';
      } else {
        res[slow--] = array[i];
      }
    }
    
    return new String(res);
  }
