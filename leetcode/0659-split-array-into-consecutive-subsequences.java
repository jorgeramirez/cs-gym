class Solution {

    public boolean isPossible(int[] nums) {
        if (nums.length == 0) {
            return true;
        }

        List<Interval> intervals = new ArrayList<>();
        for (int number : nums) {
            PriorityQueue<Interval> q = new PriorityQueue<>(
                (a, b) -> (a.size() - b.size())
            );
            for (Interval itv : intervals) {
                if (number - 1 == itv.up) {
                    q.add(itv);
                }
            }
            if (q.isEmpty()) {
                intervals.add(new Interval(number, number));
            } else {
                Interval target = q.poll();
                target.up = number;
            }
        }

        for (Interval itv : intervals) {
            if (itv.size() < 3) {
                return false;
            }
        }
        return true;
    }

    class Interval {
        int low;
        int up;

        public Interval(int _l, int _u) {
            low = _l;
            up = _u;
        }

        int size() {
            return up - low + 1;
        }
    }
}
