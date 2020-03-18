// DFS for a graph where all the nodes are reachable from the given source vertex.

import java.util.*;

public class DepthFirstSearchIterative 
{ 
    private int numVertices;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    public DepthFirstSearchIterative(int numVertices) 
    { 
        this.numVertices = numVertices; 
        adj = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int source, int destination) 
    { 
        adj[source].add(destination);  // Add w to v's list. 
    } 
  
    // A function used by DFS 
    void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true;

        System.out.print(v + " "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator();

        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[numVertices]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited);
        
        System.out.println(); 
    } 
  
    public static void main(String args[]) 
    { 
        DepthFirstSearchIterative g = new DepthFirstSearchIterative(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.DFS(2); 
    } 
} 