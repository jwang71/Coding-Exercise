
  public String deDup(String input) {
    if (input == null || input.length() <= 1) return input;
    boolean flag = false;
    int slow = 0;
    int fast = 1;
    char[] array = input.toCharArray();
    
    while (fast < array.length) {
      if (array[fast] == array[slow]) {
        flag = true;
        fast++;
      } else if (flag == true) {
        array[slow] = array[fast++];
        flag = false;
      } else {
        array[++slow] = array[fast++];
      }
    }
    
    if (flag == true) {
      return new String(array, 0, slow);
    } else {
      return new String(array, 0, slow + 1);
    }
  }

