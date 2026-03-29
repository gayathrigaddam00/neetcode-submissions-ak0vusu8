class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        for (int i = 1; i < warehouse.length; i++) {
            warehouse[i] = Math.min(warehouse[i], warehouse[i - 1]);
        }
        Arrays.sort(boxes);
        int boxIndex = 0;
        int count = 0;
        for (int i = warehouse.length - 1; i >= 0 && boxIndex < boxes.length; i--) {
            if (boxes[boxIndex] <= warehouse[i]) {
                count++;
                boxIndex++;
            }
        }
        return count;
    }
}