class Solution {

    public int minAreaRect(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            set.add(points[i][0] + "-" + points[i][1]);
        }

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                int[] p3 = { p1[0], p2[1] };
                int[] p4 = { p2[0], p1[1] };
                if (
                    !set.contains(p3[0] + "-" + p3[1]) ||
                    !set.contains(p4[0] + "-" + p4[1])
                ) {
                    continue;
                }

                // width * length
                int area = Math.abs(p1[1] - p3[1]) * Math.abs(p1[0] - p4[0]);
                minArea = Math.min(minArea, area);
            }
        }
        return minArea != Integer.MAX_VALUE ? minArea : 0;
    }
}
