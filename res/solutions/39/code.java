public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return search(0, candidates, target);
    }

    private List<List<Integer>> search(int s, int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();

        for (int i = s; i < candidates.length; ++i) {
            final int num = candidates[i];
            if (num < target) {
                for (List<Integer> lst : search(i, candidates, target - num)) {
                    List<Integer> l = new LinkedList<>(lst);
                    l.add(0, num);
                    ans.add(l);
                }
            } else if (num == target) {
                ans.add(Collections.singletonList(num));
            }
        }

        return ans;
    }
}
