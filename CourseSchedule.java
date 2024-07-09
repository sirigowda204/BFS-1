// Time Complexity : O(V+E), V-number of courses, E-no of prerequisities
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    Map<Integer, List<Integer>> hashmap = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    int count = 0;

    // Counting the number of in-degrees for each course.
    // Adding to a map, all the courses that are dependent on a particular course.
    for(int[] prereq: prerequisites) {
      indegree[prereq[0]]++;
      hashmap.computeIfAbsent(prereq[1], k -> new ArrayList<>()).add(prereq[0]);
    }

    // Adding to queue, all the courses that are independent of other courses.
    for(int i = 0; i<indegree.length; i++) {
      if(indegree[i]==0) {
        queue.add(i);
        count++;
      }
    }

    // Decrementing the dependence of a course that is in queue
    // Adding the course if it is no longer dependent on any other course.
    while(!queue.isEmpty()) {
      int current = queue.poll();
      List<Integer> dependents = hashmap.get(current);
      if(dependents!=null) {
        for(int i: dependents) {
          indegree[i]--;
          if(indegree[i]==0) {
            queue.add(i);
            count++;
          }
        }
      }

    }

    // If all courses in in-degree is 0, return true.
    if(count==indegree.length) return true;
    return false;

  }
}