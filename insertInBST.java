  public TreeNode insert(TreeNode root, int key) {
    if (root == null) return new TreeNode(key);
    if (root.key == key) {
      return root;
    } else if (root.key < key) {
      if (root.right == null) {
        root.right = new TreeNode(key);
      } else {
        root.right = insert(root.right, key);
      }
    } else {
      if (root.left == null) {
        root.left = new TreeNode(key);
      } else {
        root.left = insert(root.left, key);
      }
    }
    return root;
  }