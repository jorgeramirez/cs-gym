import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {

    // Backtracking
    public List<String> generateParenthesis(int n) {
        List<String> cmb = new ArrayList();
        backtrack(cmb, n, "", 0, 0);
        return cmb;
    }

    public void backtrack(
        List<String> cmb,
        int n,
        String current,
        int left,
        int right
    ) {
        if (current.length() == 2 * n) {
            cmb.add(current);
            return;
        }

        if (left < n) {
            backtrack(cmb, n, current + "(", left + 1, right);
        }
        if (right < left) {
            backtrack(cmb, n, current + ")", left, right + 1);
        }
    }
// DP
//     public List<String> generateParenthesis(int n) {
//       Map<Integer, List<String>> dp = new HashMap<>();
//       dp.put(0, new ArrayList<>());
//       dp.get(0).add("");
//       for(int i = 1; i <= n; i++) {
//         List<String> current = new ArrayList<>();
//         // we build the nested parenthesis
//         for(String s: dp.get(i-1)){
//           current.add("(" + s + ")");
//         }
//         // DP[i] represents 2 * i parens, so to obtain these
//         // it depends on the previous entries in DP that add up to
//         // 2 * i. For example, DP[2] = DP[1] + DP[1]
//         // DP[3] = DP[2]+ DP[1] but also DP[3] = DP[1] + DP[2]
//         // because order matters.
//         // so we turn i=3 into 1-2, 2-1
//         for(int l = 1; l < i; l++) {
//           int r = i - l;
//           // e.g., DP[3] = DP[2]+ DP[1] or DP[3] = DP[1] + DP[2]
//           for(String ls: dp.get(l)){  // left member in the sum
//             for(String rs: dp.get(r)) { // right membr in the sum
//               current.add(ls + rs);
//             }
//           }
//         }
//         dp.put(i, current);
//       }
//       Set<String> out = new HashSet(dp.get(n));
//       return new ArrayList(out);
//     }
}
