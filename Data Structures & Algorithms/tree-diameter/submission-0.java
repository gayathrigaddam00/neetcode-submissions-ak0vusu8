class Solution {
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int farthestNode = bfs(0, graph)[0];
        int diameter = bfs(farthestNode, graph)[1];
        return diameter;
    }

    private int[] bfs(int start, List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        queue.offer(start);
        visited[start] = true;
        int farthestNode = start;
        int distance = -1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                farthestNode = node;
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        return new int[]{farthestNode, distance};
    }
}