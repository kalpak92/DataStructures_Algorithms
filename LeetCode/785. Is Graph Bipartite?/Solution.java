/**
 * Given an undirected graph, return true if and only if it is bipartite.
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B 
 * such that every edge in the graph has one node in A and another node in B.
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  
 * There are no self edges or parallel edges: graph[i] does not contain i, 
 * and it doesn't contain any element twice.
 * 
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * 
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 * 
 * Note:
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 * The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 */

public class Solution {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            // keeps track of all the nodes that have been visited and also colors them to track the nodes such that the neighbours have different colors.
            
            int[] visited = new int[graph.length];
            
            // Loop across the nodes that have not been visited.
            // Add them to a queue to process them in a Breadth First manner.
            
            for(int i = 0; i < graph.length; i++)
            {
                if(visited[i] == 0) // Node has not been visited
                {
                    // Add it to the queue and mark it visited
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i);
                    visited[i] = 1;
                    
                    // Process the neighbours of the Node.
                    while(!q.isEmpty())
                    {
                        Integer tempNode = q.poll();
                        
                        for(int adj : graph[tempNode])
                        {
                            // Check if the adjacent has same color or not. If yes, then return False.
                            if(visited[adj] == visited[tempNode])
                                return false;
                            else if(visited[adj] == 0)  // adjacent node has note been visited.
                            {
                                q.offer(adj);           // add it to the queue.
                                visited[adj] = -visited[tempNode];  // Mark it visited and color the node accordingly.
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}