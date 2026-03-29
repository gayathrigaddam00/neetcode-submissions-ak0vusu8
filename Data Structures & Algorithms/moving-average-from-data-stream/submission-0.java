class MovingAverage {
    int size;
    Queue<Integer> q = new LinkedList<>();
    double sum = 0;

    public MovingAverage(int size) {
        this.size = size;
    }
    public double next(int val) {
        q.offer(val);
        sum += val;
        if (q.size() > size) {
            sum -= q.poll();
        }
        return sum / q.size();
    }
}