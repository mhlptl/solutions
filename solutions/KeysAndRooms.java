package solutions;

import java.util.Arrays;
import java.util.List;

/**
 * LEETCODE: Keys and Rooms (841) [MEDIUM]
 * 
 * use dfs to visit every room we can from the current room
 * all values in the visited array should be true if all rooms are accessible
 * 
 */
public class KeysAndRooms {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean[] visited = new boolean[rooms.size()];
    Arrays.fill(visited, false);
    dfs(rooms, 0, visited);
    
    for(boolean bool: visited) {
      if(!bool) return false;
    }
    return true;
  }
  
  private void dfs(List<List<Integer>> rooms, int index, boolean[] visited) {
    if(visited[index]) {
      return;
    }
    visited[index] = true;
    
    List<Integer> currentRoom = rooms.get(index);
    
    for(Integer keys: currentRoom) {
      dfs(rooms, keys, visited);
    }
  }

}