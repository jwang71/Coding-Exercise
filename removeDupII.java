  public String deDup(String input) {
    if (input == null || input.length() <= 2) return input;
    char[] array = input.toCharArray();
    int slow = 1;
    int fast = 2;
    
    while (fast < array.length) {
      if (array[fast] != array[slow - 1]) {
        array[++slow] = array[fast++];
      } else {
        fast++;
      }
    }
    
    return new String(array, 0, slow + 1);
  }