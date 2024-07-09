// Time Complexity : O(n)
// Space Complexity : dfs - O(1), bfs - O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// DFS APPROACH
class Solution {
  List<List<Integer>> result;
  public List<List<Integer>> levelOrder(TreeNode root) {
    result = new ArrayList<>();
    bfs(root, 0);
    return result;
  }

  void bfs(TreeNode root, int level) {
    // Base
    if(root == null) return;

    // Logic
    if(result.size() == level) {
      List<Integer> newLevel = new ArrayList<>();
      result.add(newLevel);
    }
    result.get(level).add(root.val);

    // Recurse
    bfs(root.left, level+1);
    bfs(root.right, level+1);
  }
}

// BFS APPROACH
/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i<size; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);
                if(current.left!=null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
            }
            result.add(level);
        }
        return result;
    }
}
*/