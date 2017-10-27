class Solution {
//create a graph , then BFS

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        //adding arcs
        for (int i = 0; i < equations.length; i++) {
            addArc(graph, equations[i][0], equations[i][1], values[i]);
            addArc(graph, equations[i][1], equations[i][0], 1/values[i]);
        }
        
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = findValue(graph, queries[i][0], queries[i][1]);
        }
        return res;
    }
    
    public double findValue(Map<String, Map<String, Double>> graph, String vexStart, String vexEnd) {
        if (graph.get(vexStart) == null || graph.get(vexEnd) == null) {
            return -1;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Double> values = new HashMap<>();
        
        queue.add(vexStart);
        visited.add(vexStart);
        values.put(vexStart, (double)1);
        
        String cur;
        String next;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (Map.Entry<String, Double> arc : graph.get(cur).entrySet()) {
                next = arc.getKey();
                if (next.equals(vexEnd)) {
                    return values.get(cur) * arc.getValue();
                } else if (!visited.contains(next)) {
                    values.put(next, values.get(cur) * arc.getValue());
                    queue.offer(next);
                    visited.add(next);
                }
            } 
        }
        return -1;
    }
    
    public void addArc(Map<String, Map<String, Double>> graph, String vexStart, String vexEnd, Double value) {
        Map<String, Double> arc;
        if (graph.containsKey(vexStart)) {
            arc = graph.get(vexStart);
        } else {
            arc = new HashMap<>();
        }
        arc.put(vexEnd, value);
        graph.put(vexStart, arc);
    }
}