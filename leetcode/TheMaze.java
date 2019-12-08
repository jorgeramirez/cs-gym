import java.util.*;

// https://leetcode.com/articles/the-maze/
public class TheMaze {

    static int WALL = 1;
    static int NO_WALL = 0;

    static int LEFT = 1;
    static int TOP = 2;
    static int RIGHT = 3;
    static int BOTTOM = 4;


    public boolean solve(int[][] inputMaze, int rowStart, int colStart, int rowDest, int colDest) {
        // The idea is to do BFS until we stop at (rowDest, colDest) and we return true,
        // or we return to the beginning and have no other choice (we return false).
        // for tracking visited neighbors we use use a hash table here "row-col" => true.
        // Time: O(|V| + |E|)   V: nodes, E: links
        // Space: O(|V|)  we keep a queue and a hash table.

        // 1) create a queue of positions, and put the starting position in the queue
        // 2) while the queue is not empty
        //    2.1) extract an element from the queue
        //    2.2) get unvisited neighbors (directions to move the ball)
        //    2.3) roll the ball in each possible direction and get the final position of the ball.
        //    2.4) for each landing position
        //    2.4.1) if the position is our destination return true.
        //    2.4.2) if we haven't seen this position before, we add it to the queue,
        //           and mark the position as visited.
        // 3) return false
        Queue<Position> queue = new LinkedList<>();
        HashMap<String, Boolean> visitedPositions = new HashMap<>();
        Maze maze = new Maze(inputMaze);
        Position start = new Position(rowStart, rowDest);
        queue.add(start);
        Position current;

        while (!queue.isEmpty()) {
            current = queue.poll();
            List<Position> neighbors = getNeighbors(current, maze, visitedPositions);

            for (Position pos : neighbors) {
                Position posLanded = roll(pos, maze);

                if (posLanded.row == rowDest && posLanded.col == colDest) {
                    return true;
                }

                if (!visitedPositions.getOrDefault(posLanded.getKey(), false)) {
                    queue.add(posLanded);
                    visitedPositions.put(posLanded.getKey(), true);
                }
            }
        }
        return false;
    }

    // return the neighbors that we should consider given the current position, maze and visited positions.
    private List<Position> getNeighbors(Position current, Maze maze, HashMap<String, Boolean> visitedPositions) {
        List<Position> neighbors = new ArrayList<>();

        for (Position pos : current.getNeighbors()) {
            if (maze.isPositionValid(pos) && !visitedPositions.getOrDefault(pos.getKey(), false)) {
                neighbors.add(pos);
            }
        }
        return neighbors;
    }

    private Position roll(Position pos, Maze maze) {
        Position current = pos;

        while (maze.isPositionValid(current)) {

            if (current.direction == LEFT) {
                current = current.getLeft();
            } else if (current.direction == TOP) {
                current = current.getTop();
            } else if (current.direction == RIGHT) {
                current = current.getRight();
            } else {
                current = current.getBottom();
            }
        }

        // undo last move and return
        if (current.direction == LEFT) {
            current = current.getRight();
        } else if (current.direction == TOP) {
            current = current.getBottom();
        } else if (current.direction == RIGHT) {
            current = current.getLeft();
        } else {
            current = current.getTop();
        }
        return current;
    }

    static class Position {
        Integer row;
        Integer col;
        // indicate that the ball should roll towards the given direction
        Integer direction;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        Position(int row, int col, Integer direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }

        String getKey() {
            return row + "-" + col;
        }

        Position getTop() {
            return new Position(row - 1, col, TOP);
        }

        Position getLeft() {
            return new Position(row, col - 1, LEFT);
        }

        Position getRight() {
            return new Position(row, col + 1, RIGHT);
        }

        Position getBottom() {
            return new Position(row + 1, col, BOTTOM);
        }

        List<Position> getNeighbors() {
            List<Position> positions = new ArrayList<>();
            positions.add(getLeft());
            positions.add(getTop());
            positions.add(getRight());
            positions.add(getBottom());
            return positions;
        }
    }


    static class Maze {
        int[][] maze;

        Maze(int[][] maze) {
            this.maze = maze;
        }

        Boolean isPositionValid(Position pos) {
            boolean boundariesOk = (pos.row >= 0 && pos.row < maze.length) && (pos.col >= 0 && pos.col <= maze[0].length);
            // is valid if is not a wall
            return boundariesOk && maze[pos.row][pos.col] == NO_WALL;
        }
    }


    public static void main(String[] args) {
        TheMaze s = new TheMaze();
        // this one should return true
        int[][] maze = new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 0, 0, 1, 0, 0, 1},
                new int[]{1, 0, 0, 0, 0, 0, 1},
                new int[]{1, 0, 0, 0, 1, 0, 1},
                new int[]{1, 1, 1, 0, 1, 1, 1},
                new int[]{1, 0, 0, 0, 0, 0, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
        };
        System.out.println(s.solve(maze, 0 + 1, 4 + 1, 4 + 1, 4 + 1));

        // this one should return false
        maze = new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 0, 0, 1, 0, 0, 1},
                new int[]{1, 0, 0, 0, 0, 0, 1},
                new int[]{1, 0, 0, 0, 1, 0, 1},
                new int[]{1, 1, 1, 0, 1, 1, 1},
                new int[]{1, 0, 0, 0, 0, 0, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
        };
        System.out.println(s.solve(maze, 0 + 1, 4 + 1, 3 + 1, 2 + 1));
    }
}
