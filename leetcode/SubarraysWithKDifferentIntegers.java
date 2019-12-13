import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        // TLE
        // we use sliding window
        // 1) we build an array of sets, this array has size K
        //    the index of this array represents the start of our sliding window [i, j)
        //    while we build we check the size of the result set for window [i, j) and if the size is K then we
        //   already increment our counter
        // 2) we start to loop for subsequent window sizes and check that the size of the set is still K
        List<Set<Integer>> windows = new ArrayList<>();
        Set<Integer> tmp;
        int res = 0;

        for (int i = 0; i <= A.length - K; i++) {
            tmp = new HashSet<>();
            tmp.add(A[i]);

            for (int j = i + 1; j < i + K; j++) {
                tmp.add(A[j]);
            }
            if (tmp.size() == K) {
                ++res;
            }
            windows.add(tmp);
        }

        System.out.println(windows);

        for (int w = K; w < A.length; w++) {
            for (int i = 0; i < A.length - w; i++) {
                windows.get(i).add(A[i + w]);

                if (windows.get(i).size() == K) {
                    ++res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraysWithKDifferentIntegers s = new SubarraysWithKDifferentIntegers();
        System.out.println(s.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }
}
