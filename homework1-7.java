 //strStr
  public int strstr(String large, String small) {
    // write your solution here
    for (int i = 0; i < large.length() - small.length() + 1; i++) {
      int j;
      for (j = 0; j < small.length(); j++) {
        if (large.charAt(i+j) != small.charAt(j)) {
          break;
        }
      }
      if (j == small.length()) {
        return i;
      }
    }
    return -1;
  }

//remove adjacent repeated characters
public String deDup(String input) {
  Stack<Character> stack = new Stack<>();

  int slow = 0;
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
