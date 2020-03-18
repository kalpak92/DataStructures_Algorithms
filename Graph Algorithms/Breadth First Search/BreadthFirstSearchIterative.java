import java.util.*;

public class BreadthFirstSearchIterative
{
    private int numVertices;
    private LinkedList<Integer> adj[];

    public BreadthFirstSearchIterative(int numVertices)
    {
        this.numVertices = numVertices;
        adj = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) 
            adj[i] = new LinkedList(); 
    }

    public void addEdge(int source, int destination){

        //add edge
        adj[source].addFirst(destination);

        //add back edge ((for undirected)
        adj[destination].addFirst(source);
    }

    void BFSIterative(int source) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[numVertices]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[source] = true; 
        queue.add(source); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            source = queue.poll(); 
            System.out.print(source + " "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[source].listIterator(); 
            while (i.hasNext()) 
            { 
                int temp = i.next(); 
                if (!visited[temp]) 
                { 
                    visited[temp] = true; 
                    queue.add(temp); 
                } 
            } 
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        BreadthFirstSearchIterative g = new BreadthFirstSearchIterative(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFSIterative(2); 
    }
}