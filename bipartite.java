/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    if (graph == null) return true;
    
    Queue<GraphNode> q = new LinkedList<>();
    q.offer(graph.get(0));
    Map<GraphNode, Integer> map = new HashMap<>();
    map.put(graph.get(0), 0);
    
    while (!q.isEmpty()) {
      GraphNode node = q.poll();
      int nei = map.get(node) == 0 ? 1 : 0;
      
      for (GraphNode n : node.neighbors) {
        if (!map.containsKey(n)) {
          map.put(n, nei);
          q.offer(n);
        } else {
          if (map.get(n) != nei) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
