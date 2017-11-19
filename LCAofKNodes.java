  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    if (root == null) return null;
    for (TreeNode node : nodes) {
      if (node == root) return root;
    }
    
    TreeNode left = lowestCommonAncestor(root.left, nodes);
    TreeNode right = lowestCommonAncestor(root.right, nodes);
    if (left == null && right == null) return null;
    if (left != null && right != null) return root;
    return left == null ? right : left;
  }