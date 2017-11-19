  public TreeNode delete(TreeNode root, int key) {
    if (root == null) return null;
    if (root.key < key) {
      root.right = delete(root.right, key);
    } else if (root.key > key) {
      root.left = delete(root.left, key);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null || root.right == null) {
        return root.left == null ? root.right : root.left;
      } else {
        TreeNode smallest = findSmallest(root.right);
        root.key = smallest.key;
        root.right = delete(root.right, smallest.key);
      }
    }
    return root;
  }
  
  public TreeNode findSmallest(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }