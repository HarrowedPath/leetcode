package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        boolean output = false;
        assert output == new CourseSchedule().BFSTopologicalSort(2,
                new int[][]{{1,0},{0,1}}
        );
    }

    public boolean BFSTopologicalSort(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjLists = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjLists.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjLists.get(prerequisite[1]).add(prerequisite[0]);
        }


        Queue<Integer> q = new LinkedList<>();
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int e : adjLists.get(i)) {
                degree[e]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        int i=0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            i++;
            for (int e : adjLists.get(node)) {
                degree[e]--;
                if (degree[e] == 0) q.add(e);
            }
        }
        return i == numCourses;
    }
}
