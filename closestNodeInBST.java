  public int closest(TreeNode root, int target) {
    if (root == null) return -1;
    int diff = Integer.MAX_VALUE;
    TreeNode result = root;
    
    while (root != null) {
      if (root.key == target) {
        return root.key;
      } else {
        result = Math.abs(root.key - target) < Math.abs(result.key - target) ? root : result;
        if (root.key < target) {
          root = root.right;
        } else {
          root = root.left;
        }
      }
    }
    return result.key;
  }