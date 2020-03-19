import java.util.*;

public class DetectCycleDirectedGraph
{
    static class Graph 
    {
        int vertices;
    
        LinkedList<Integer>[] adjList;

        // Constructor
        Graph(int vertices) 
        {
            this.vertices = vertices;
        
            adjList = new LinkedList[vertices];
        
            for (int i = 0; i < vertices; i++) 
            {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination) 
        {
            adjList[source].addFirst(destination);
        }

        public boolean isCycle() 
        {
            boolean visited[] = new boolean[vertices];
            boolean recursiveArr[] = new boolean[vertices];

            //do DFS from each node
            for (int i = 0; i < vertices; i++) 
            {
                if(visited[i] == false)
                {   
                    if (isCycleUtil(i, visited, recursiveArr))
                        return true;
                }
            }
            return false;
        }

        public boolean isCycleUtil(int vertex, boolean[] visited, boolean[] recursiveArr) 
        {
            visited[vertex] = true;
            recursiveArr[vertex] = true;

            //recursive call to all the adjacent vertices
            for (int i = 0; i < adjList[vertex].size(); i++) 
            {
                //if not already visited
                int adjVertex = adjList[vertex].get(i);
            
                // Not present in visited array and DFS recursion returns True -> So Cycle exists.
                if (!visited[adjVertex] && isCycleUtil(adjVertex, visited, recursiveArr)) 
                {
                    return true;
                }
                // If you encounter a vertex which already present in recursion stack -> CYCLE Exists.
                else if (recursiveArr[adjVertex])
                    return true;
            }
            // if reached here, that means cycle has not found in DFS from this vertex
            // reset the recursive stack and return false.
            recursiveArr[vertex] = false;
            return false;
        }
    }
    public static void main(String[] args) 
    {
        int vertices = 5;
        Graph graph = new Graph(vertices);

        graph.addEgde(0, 1);
        graph.addEgde(1, 3);
        graph.addEgde(2, 0);
        graph.addEgde(0, 2);
        graph.addEgde(3, 4);
        graph.addEgde(4, 4);
    
        boolean result = graph.isCycle();
    
        System.out.println("is Cycle present in the Directed Graph: " + result);
    }
}