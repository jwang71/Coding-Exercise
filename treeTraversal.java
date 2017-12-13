//tree traversal iteratively
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> list  = new ArrayList<>();
    if (root == null) return list;
    
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      list.add(cur.key);
      cur = cur.right;
    }
    return list;
  }

  public List<Integer> preOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Stack<TreeNode> stack = new Stack<>();
    
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      res.add(cur.key);
      if (cur.right != null) {
        stack.push(cur.right);
      }
      if (cur.left != null) {
        stack.push(cur.left);
      }
    }
    return res;
  }

  public List<Integer> postOrder(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) return res;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      res.add(0, cur.key);
      if (cur.left != null) {
        stack.push(cur.left);
      }
      if (cur.right != null) {
        stack.push(cur.right);
      }
    }
    return res;
  }

  //second solution for iterative postorder traversal
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    TreeNode pre = null;
    TreeNode cur = root;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.isEmpty()) {
      cur = stack.peek();
      //traverse down the tree
      if (pre == null || pre.left == cur || pre.right == cur) {
        if (cur.left != null) {
          stack.push(cur.left);
        } else if (cur.right != null) {
          stack.push(cur.right);  
        }
      } else if (cur.left == pre) { //traverse up from left
        if (cur.right != null) stack.push(cur.right);
      } else { // traverse up from right
        res.add(cur.key);
        stack.pop();
      }
      pre = cur;
    }
    return res;
  }
//recursion
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here.
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    List<Integer> left = inOrder(root.left);
    List<Integer> right = inOrder(root.right);

    res.addAll(left);
    res.add(root.key);

    res.addAll(right);
    return res;
  }
  
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    List<Integer> left = preOrder(root.left);
    List<Integer> right = preOrder(root.right);
    res.add(root.key);

    res.addAll(left);
    res.addAll(right);
    return res;
  }

  public List<Integer> postOrder(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) return res;
    
    List<Integer> left = postOrder(root.left);
    List<Integer> right = postOrder(root.right);
    
    res.addAll(left);
    res.addAll(right);
    res.add(root.key);
    return res;
  }