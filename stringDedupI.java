  public String deDup(String input) {
    if (input == null || input.length() <= 1) return input;
    char[] array = input.toCharArray();
    int slow = 0;
    int fast = 1;
    
    while (fast < array.length) {
      if (array[fast] == array[slow]) {
        fast++;
      } else {
        array[++slow] = array[fast++];
      }
    }
    
    return new String(array, 0, slow + 1);
  } 