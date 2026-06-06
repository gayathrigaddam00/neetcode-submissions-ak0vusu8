class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre :prerequisites){
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }
        Set<Integer>[] ancestors = new HashSet[numCourses];
        for(int i=0;i<numCourses;i++){
            ancestors[i]= new HashSet<>();
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei:adj.get(node)){
                ancestors[nei].add(node);
                ancestors[nei].addAll(ancestors[node]);
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for(int query[] : queries){
            result.add(ancestors[query[1]].contains(query[0]));
        }
        return result;
    }
}