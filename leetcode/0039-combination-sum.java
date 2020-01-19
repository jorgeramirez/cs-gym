import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new ArrayList<Integer>(), 0, 0);
        return res;
    }

    void backtrack(
        int[] candidates,
        int target,
        List<List<Integer>> res,
        List<Integer> cmb,
        int sum,
        int index
    ) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(cmb));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if (num + sum > target) {
                continue;
            }
            cmb.add(num);
            backtrack(candidates, target, res, cmb, num + sum, i);
            cmb.remove(cmb.size() - 1);
        }
    }
}
