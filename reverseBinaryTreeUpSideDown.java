  public TreeNode reverse(TreeNode root) {
    if (root == null || root.left == null) return root;
    TreeNode left = root.left;
    TreeNode newRoot = reverse(left);
    left.left = root;
    left.right = root.right;
    root.left = null;
    root.right = null;
    return newRoot;
  }