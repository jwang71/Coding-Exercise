/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */

  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    int oneLevel = getLevel(one);
    int twoLevel = getLevel(two);
    if (oneLevel >= twoLevel) {
      while (oneLevel != twoLevel) {
        one = one.parent;
        oneLevel--;
      }
    } else {
      while (oneLevel != twoLevel) {
        two = two.parent;
        twoLevel--;
      }
    }
    
    while (one != null && two != null && one != two) {
      one = one.parent;
      two = two.parent;
    }
    if (one == null || two == null) return null;
    return one;
  }
  
  public int getLevel(TreeNodeP node) {
    int level = 0;
    while (node != null) {
      node = node.parent;
      level++;
    }
    return level;
  }

