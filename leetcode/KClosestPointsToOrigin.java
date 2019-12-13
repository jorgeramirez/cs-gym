//https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.Objects;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        // build a min heap and extract k points from the heap
        PriorityQueue<Point> heap = new PriorityQueue<Point>((p1, p2) -> {
            double diff = p1.d - p2.d;
            if (diff < 0) {
                return -1;
            }
            return 1;
        });

        for (int i = 0; i < points.length; i++) {
            heap.add(new Point(points[i][0], points[i][1]));
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point p = heap.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        return result;
    }

    static class Point {
        int x;
        int y;
        double d;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            d = Math.sqrt(Math.pow(0 - x, 2) + Math.pow(0 - y, 2));
        }

    }

    public static void main(String[] args) {
        int[][] points = new int[][]{new int[]{
                1, 3
        }, new int[]{
                -2, 2
        }};
        KClosestPointsToOrigin s = new KClosestPointsToOrigin();
        int[][] out = s.kClosest(points, 1);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i][0] + "," + out[i][1]);
        }
    }
}
