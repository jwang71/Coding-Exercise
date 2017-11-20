  public int largestSmaller(TreeNode root, int target) {
    if (root == null) return Integer.MIN_VALUE;
    TreeNode result = null;
    while (root != null) {
      if (root.key >= target) {
        root = root.left;
      } else {
        result = root;
        root = root.right;
      }
    }
    return result == null ? Integer.MIN_VALUE : result.key;
  }