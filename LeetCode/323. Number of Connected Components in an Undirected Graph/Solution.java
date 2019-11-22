/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.
 * 
 * Example 1:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * 
 *      0          3
 *      |          |
 *      1 --- 2    4 
 * 
 * Output: 2
 * 
 * Example 2:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 * 
 * Output:  1
 * 
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and 
 * thus will not appear together in edges.
 */

class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n <= 1 || edges.length == 0)
            return n;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // initialise the map with the nodes and , for now, empty adjacency list
        for(int i = 0; i < n; i++)
        {
            map.put(i, new ArrayList<Integer>());
        }
        
        // initialise the adjacency list corresponding to the nodes
        for(int i = 0; i < edges.length; i++)
        {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        // create a set to keep track of the visited nodes
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;  // to count the number of connected components
        
        for(int i = 0; i < n; i++)
        {
            if(visited.add(i))      // add(i) return true if the element in not present in the set
            {
                dfsHelper(i, map, visited);    
                count++;            // finished processing one connected component. So increase the counter.
            }
        }
        
        return count;
    }
    
    // Take the adjacency list and traverse recursively.
    private void dfsHelper(int i, Map<Integer, List<Integer>> map, Set<Integer> visited)
    {
        for(int j: map.get(i))
        {
            if(visited.add(j))
            {
                dfsHelper(j, map, visited);
            }
        }
    }
}