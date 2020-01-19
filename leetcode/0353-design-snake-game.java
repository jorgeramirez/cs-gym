class SnakeGame {
    int rows;
    int cols;
    int score = 0;
    int[][] food;
    int currentFood = 0;
    Set<String> snakeParts = new HashSet<>();
    Map<String, int[]> dirs = new HashMap<>();
    Deque<int[]> snake = new LinkedList<>();

    /** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        rows = height;
        cols = width;
        this.food = food;
        dirs.put("U", new int[] { -1, 0 });
        dirs.put("L", new int[] { 0, -1 });
        dirs.put("R", new int[] { 0, 1 });
        dirs.put("D", new int[] { 1, 0 });
        snake.add(new int[] { 0, 0 });
        snakeParts.add("0-0");
    }

    /** Moves the snake.
    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
    @return The game's score after the move. Return -1 if game over. 
    Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] dir = dirs.get(direction);
        int[] head = snake.peekFirst();
        int[] next = new int[] { head[0] + dir[0], head[1] + dir[1] };

        if (next[0] < 0 || next[0] == rows || next[1] < 0 || next[1] == cols) {
            return -1;
        }

        if (
            currentFood < food.length &&
            next[0] == food[currentFood][0] &&
            next[1] == food[currentFood][1]
        ) {
            ++score;
            snake.addFirst(next);
            snakeParts.add(next[0] + "-" + next[1]);
            ++currentFood;
            return score;
        }
        int[] tail = snake.removeLast();
        snakeParts.remove(tail[0] + "-" + tail[1]);

        if (snakeParts.contains(next[0] + "-" + next[1])) {
            return -1;
        }
        snake.addFirst(next);
        snakeParts.add(next[0] + "-" + next[1]);
        return score;
    }
}
