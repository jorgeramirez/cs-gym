import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> single = new ArrayList<Integer>();
            single.add(nums[i]);
            ans.add(single);
            backtrack(nums, ans, new ArrayList<Integer>(single), i + 1);
        }
        return ans;
    }

    void backtrack(
        int[] nums,
        List<List<Integer>> sets,
        List<Integer> cur,
        int index
    ) {
        if (cur.size() == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            sets.add(new ArrayList<Integer>(cur));
            backtrack(nums, sets, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
