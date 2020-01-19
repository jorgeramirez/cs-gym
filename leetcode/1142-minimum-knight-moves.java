class Solution {

    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        int[] dx = { -1, 1, 2, 2, 1, -1, -2 };
        int[] dy = { 2, 2, 1, -1, -2, -2, -1 };
        int curX = 0;
        int curY = 0;
        x = Math.abs(x);
        y = Math.abs(y);
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { curX, curY });
        visited.add("0-0");
        int answer = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            ++answer;
            while (len > 0) {
                int[] point = q.poll();
                for (int i = 0; i < dx.length; i++) {
                    int[] move = { point[0] + dx[i], point[1] + dy[i] };
                    if (move[0] == x && move[1] == y) {
                        return answer;
                    }
                    if (visited.contains(move[0] + "-" + move[1])) {
                        continue;
                    }
                    if (move[0] >= -1 && move[1] >= -1) {
                        q.add(move);
                        visited.add(move[0] + "-" + move[1]);
                    }
                }
                --len;
            }
        }
        return 0;
    }
}
