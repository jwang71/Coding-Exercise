  public TreeNode search(TreeNode root, int key) {
    if (root == null) return null;
    if (root.key == key) {
      return root;
    } else if (root.key > key) {
      return search(root.left, key);
    } else {
      return search(root.right, key);
    }
  }