  private char[] ps = new char[]{'(',')','[',']','{','}'};
  public List<String> validParentheses(int l, int m, int n) {
    int[] remain = new int[]{l, l, m, m, n, n};
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    int length = 2 * (l + m + n);
    dfs(remain, length, stack, list, sb);
    return list;
  }
  
  public void dfs(int[] remain, int length, Stack<Character> stack, List<String> list, StringBuilder sb) {
    if (sb.length() == length) {
      list.add(new String(sb));
      return;
    }
    
    for (int i = 0; i < ps.length; i++) {
      if (i % 2 == 0) {
        if (remain[i] > 0) {
          sb.append(ps[i]);
          stack.push(ps[i]);
          remain[i]--;
          dfs(remain, length, stack, list, sb);
          sb.deleteCharAt(sb.length() - 1);
          stack.pop();
          remain[i]++;
        }
      } else {
        if (!stack.isEmpty() && stack.peek() == ps[i-1]) {
          sb.append(ps[i]);
          stack.pop();
          remain[i]--;
          dfs(remain, length, stack, list, sb);
          sb.deleteCharAt(sb.length() - 1);
          stack.push(ps[i - 1]);
          remain[i]++;
        }
      }
    }
  } 
    

