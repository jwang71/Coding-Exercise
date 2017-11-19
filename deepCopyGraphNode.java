/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
  public List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null) return null;
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        map.put(node, new GraphNode(node.key));
        dfs(node, map);
      }
    }
    return new ArrayList<GraphNode>(map.values());
  }
  
  public void dfs(GraphNode node, Map<GraphNode, GraphNode> map) {
    if (node == null) return;
    GraphNode copy = map.get(node);
    
    for (GraphNode nei : node.neighbors) {
      if (!map.containsKey(nei)) {
        map.put(nei, new GraphNode(nei.key));
        dfs(nei, map);
      }
      copy.neighbors.add(map.get(nei));
    }
  }
