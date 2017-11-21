  public List<String> subSets(String set) {
    List<String> result = new ArrayList<String>();
    if (set == null) {
      return result;
    }
    StringBuilder sb = new StringBuilder();
    char[] array = set.toCharArray();
    Arrays.sort(array);
    helper(array, 0, sb, result);
    return result;
  }
  
  public void helper(char[] array, int index, StringBuilder sb, List<String> result) {
    if (index == array.length) {
      result.add(new String(sb));
      return;
    }
    
    sb.append(array[index]);
    helper(array, index+1, sb, result);
    sb.deleteCharAt(sb.length() - 1);
    
    while (index < array.length-1 && array[index+1] == array[index]) {
      index++;
    }
    helper(array, index+1, sb, result);
  }  
