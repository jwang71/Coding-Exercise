  public String reverseWords(String input) {
    if (input == null || input.length() == 0) return input;
    String[] array = input.split(" ");
    
    StringBuilder sb = new StringBuilder();
    
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] != "") {
        sb.append(array[i]).append(' ');
      }
    }
    return sb.toString().trim();
  }


  //solution2
  public String reverseWords(String input) {
    if (input == null || input.length() == 0) return input;
    int i = 0;
    
    char[] array = input.toCharArray();
    
    while (i < input.length()) {
      while (i < input.length() && input.charAt(i) == ' ') {
        i++;
      }
      
      int start = i;
      while (i < input.length() && input.charAt(i) != ' ') {
        i++;
      }
      reverse(array, start, i - 1);
    }
    
    reverse(array, 0, input.length() - 1);
    return new String(array);
  }
  
  public void reverse(char[] array, int start, int end) {
    while (start <= end) {
      swap(array, start++, end--);
    }
  }
  public void swap(char[] array,  int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
