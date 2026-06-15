class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> hs = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,-1});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0],parent = curr[1];
            if(hs.contains(node)) return false;

            hs.add(node);
            for(int nei:adj.get(node)){
                if (nei != parent && !hs.contains(nei)) {
                q.offer(new int[]{nei, node});
            }
            }
        }
        return hs.size()==n;
    }
}
