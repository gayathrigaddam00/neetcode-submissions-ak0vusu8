class FirstUnique {
    private Queue<Integer> queue = new ArrayDeque<>();
    private Map<Integer, Boolean> hm = new HashMap<>();
    public FirstUnique(int[] nums) {
        for(int num:nums){
            this.add(num);
        }
    }
    
    public int showFirstUnique() {
        while(!queue.isEmpty() && !hm.get(queue.peek())){
            queue.remove();
        }
        if(!queue.isEmpty()){
            return queue.peek();
        }
        return -1;
    }
    
    public void add(int value) {
        if(!hm.containsKey(value)){
            hm.put(value,true);
            queue.add(value);
        }else{
            hm.put(value,false);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
