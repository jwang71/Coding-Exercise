  public String deDup(String input) {
    if (input == null || input.length() <= 1) return input;
    
    Stack<Character> stack = new Stack<>();
    int i = 0;
    char[] array = input.toCharArray();
    
    while (i < array.length) {
      if (!stack.isEmpty() && array[i] == stack.peek()) {
        while (i < array.length && array[i] == stack.peek()) {
          i++;
        }
        stack.pop();
      } else {
        stack.push(array[i]);
        i++;
      }
    }
    
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    
    return sb.reverse().toString();
  }


  public String deDup(String input) {
    if (input == null || input.length() <= 1) return input;
    
    int slow = 0;
    int fast = 1;
    char[] array = input.toCharArray();
    
    while (fast < array.length) {
      if (slow >= 0 && array[slow] == array[fast]) {
        while (fast < array.length && array[fast] == array[slow]) {
          fast++;
        }
        slow--;
      } else {
        int j = fast;
        while (j + 1< array.length && array[j+1] == array[fast]) {
          j++;
        }
        if (j != fast) {
          fast = j + 1;
        } else {
          array[++slow] = array[fast++];
        }
      }
    }
    return slow == -1 ? "" : new String(array, 0, slow+1);
  }
