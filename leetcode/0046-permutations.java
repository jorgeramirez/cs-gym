import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            lNums.add(nums[i]);
        }
        backtrack(lNums, new ArrayList<Integer>(), res);
        return res;
    }

    public void backtrack(
        List<Integer> nums,
        List<Integer> cmb,
        List<List<Integer>> res
    ) {
        if (nums.isEmpty()) {
            res.add(cmb);
        }

        for (int i = 0; i < nums.size(); i++) {
            List iCmb = new ArrayList<>();
            iCmb.addAll(cmb);
            iCmb.add(nums.get(i));
            List<Integer> iNums = remove(nums, i);
            backtrack(iNums, iCmb, res);
        }
    }

    public List<Integer> remove(List<Integer> nums, int idx) {
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (i == idx) {
                continue;
            }
            r.add(nums.get(i));
        }
        return r;
    }
}
