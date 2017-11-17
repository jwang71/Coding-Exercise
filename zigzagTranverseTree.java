  public List<Integer> zigZag(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    Deque<TreeNode> q = new LinkedList<>();
    
    q.offerFirst(root);
    boolean isOdd = true;
    
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        if (!isOdd) {
          TreeNode node = q.pollFirst();
          list.add(node.key);
          if (node.left != null) {
            q.offerLast(node.left);
          }
          if (node.right != null) {
            q.offerLast(node.right);
          }
        } else {
          TreeNode node = q.pollLast();
          list.add(node.key);
          if (node.right != null) {
            q.offerFirst(node.right);
          }
          if (node.left != null) {
            q.offerFirst(node.left);
          }          
        }
      }
      isOdd = !isOdd;
    }
    return list;
  }