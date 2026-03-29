public class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void findCombinations(int[] nums,
                                  int remaining,
                                  int index,
                                  List<Integer> current,
                                  List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remaining < 0 || index == nums.length) {
            return;
        }
        current.add(nums[index]);
        findCombinations(nums, remaining - nums[index], index, current, result);
        current.remove(current.size() - 1);
        findCombinations(nums, remaining, index + 1, current, result);
    }
}