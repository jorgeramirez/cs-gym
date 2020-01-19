class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 1) {
            return true;
        }
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int preCourse = edge[1];
            graph.get(preCourse).add(course);

            if (hasCycle(graph, preCourse, new boolean[numCourses])) {
                return false;
            }
        }
        return true;
    }

    boolean hasCycle(
        List<List<Integer>> graph,
        int preCourse,
        boolean[] visited
    ) {
        if (visited[preCourse]) {
            return true;
        }
        visited[preCourse] = true;

        for (int course : graph.get(preCourse)) {
            if (hasCycle(graph, course, visited)) {
                return true;
            }
        }
        visited[preCourse] = false;
        return false;
    }
}
