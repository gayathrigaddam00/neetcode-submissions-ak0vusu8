class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        int[] inDegree = new int[n + 1];
        Set<Integer>[] graph = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new HashSet<>();

        for (List<Integer> seq : sequences) {
            for (int i = 1; i < seq.size(); i++) {
                if (graph[seq.get(i - 1)].add(seq.get(i))) {
                    inDegree[seq.get(i)]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int curr = queue.poll();
            if (idx >= n || nums[idx++] != curr) return false;
            for (int next : graph[curr]) {
                if (--inDegree[next] == 0) queue.offer(next);
            }
        }
        return idx==n;
    }
}
