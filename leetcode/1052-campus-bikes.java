import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<Tuple> tuples = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int d =
                    Math.abs(workers[i][0] - bikes[j][0]) +
                    Math.abs(workers[i][1] - bikes[j][1]);
                tuples.add(new Tuple(i, j, d));
            }
        }
        PriorityQueue<Tuple> q = new PriorityQueue(tuples);
        Set<Integer> bikesAsig = new HashSet<Integer>();
        int ans[] = new int[workers.length];
        Arrays.fill(ans, -1);
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            if (bikesAsig.contains(t.ib)) {
                continue;
            }
            if (ans[t.iw] != -1) {
                continue;
            }
            ans[t.iw] = t.ib;
            bikesAsig.add(t.ib);
        }
        return ans;
    }

    class Tuple implements Comparable<Tuple> {
        int iw;
        int ib;
        int d;

        Tuple(int _iw, int _ib, int _d) {
            iw = _iw;
            ib = _ib;
            d = _d;
        }

        @Override
        public int compareTo(Tuple o) {
            if (d < o.d) {
                return -1;
            }
            if (d > o.d) {
                return 1;
            }
            if (iw < o.iw) {
                return -1;
            }
            if (iw > o.iw) {
                return 1;
            }
            if (ib < o.ib) {
                return -1;
            }
            return 1;
        }
    }
}
