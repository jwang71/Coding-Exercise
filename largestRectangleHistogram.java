  public int largest(int[] array) {
    if (array == null || array.length == 0) return 0;
    int[] left = new int[array.length];
    int[] right = new int[array.length];
    
    left[0] = 0;
    for (int i = 1; i < array.length; i++) {
      int index = i;
      
      while (index >= 0 && array[index] >= array[i]) {
        index--;
      }
      left[i] = index + 1;
    }
    
    right[array.length - 1] = array.length - 1;
    for (int i = array.length - 2; i >= 0; i--) {
      int index = i;
      while (index < array.length && array[index] >= array[i]) {
        index++;
      }
      right[i] = index - 1;
    }
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      max = Math.max(max, array[i] * (right[i] - left[i] + 1));
    }
    return max;
  }


  public int largestUsingStack(int[] array) {
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    for (int i = 0; i <= array.length; i++) {
      int cur = i == array.length ? -1 : array[i];
      while (!stack.isEmpty() && cur <= array[stack.peek()]) {
        int h = array[stack.pop()];
        int w = stack.isEmpty() ? i : i - 1 - stack.peek();
        int area = h * w;
        max = Math.max(max, area);
      }
      stack.push(i);
    }
    return max;
  }
