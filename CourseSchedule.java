
import java.util.*;

class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph[prerequisite][course] = 1;
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processedCourses++;

            for (int neighbor = 0; neighbor < numCourses; neighbor++) {
                if (graph[course][neighbor] == 1) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return processedCourses == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule sol = new CourseSchedule();

        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        boolean result = sol.canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + result); // Expected: true
    }
}
