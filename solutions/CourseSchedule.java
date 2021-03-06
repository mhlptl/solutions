package solutions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * LEETCODE: Course Scheule (207) [MEDIUM]
 * 
 * create adjacency list
 * use dfs to find a cycle
 * keep track of what we've visited (so we dont do extra work)
 * keep track of what the recursive function has visited (to find the cycle)
 */
public class CourseSchedule {
	private Map<Integer, List<Integer>> adjList;
  
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    adjList = createAdjacencyList(prerequisites);
    
    boolean[] visited = new boolean[numCourses];
    
    for(int i = 0; i < numCourses; i++) {
      boolean[] recursiveVisited = new boolean[numCourses];
      if(isCycle(i, visited, recursiveVisited)) return false;
    }
    
    return true;
  }
  
  private boolean isCycle(int currentNode, boolean[] visited, boolean[] recurseVisited) {
    if(recurseVisited[currentNode]) return true;
    if(visited[currentNode]) return false;
    
    recurseVisited[currentNode] = true;
    visited[currentNode] = true;
    
    List<Integer> neighbors = adjList.get(currentNode);
    
    if(neighbors == null) {
      recurseVisited[currentNode] = false;
      return false;
    }
    
    for(Integer neighbor: neighbors) {
      if(isCycle(neighbor, visited, recurseVisited)) return true;
    }
    
    recurseVisited[currentNode] = false;
    return false;
  }
  
  private Map<Integer, List<Integer>> createAdjacencyList(int[][] prereqs) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    for(int[] prereq: prereqs) {
      if(!map.containsKey(prereq[1])) {
        map.put(prereq[1], new ArrayList<>());
      }
      map.get(prereq[1]).add(prereq[0]);
    }
    
    return map;
  }
}
