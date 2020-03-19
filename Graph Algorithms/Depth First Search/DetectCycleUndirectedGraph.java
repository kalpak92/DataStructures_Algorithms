import java.util.LinkedList;

public class DetectCycleUndirectedGraph 
{
    static class Graph
    {
        int numVertices;
        LinkedList<Integer> [] adjList;

        // Constructor
        public Graph(int numVertices) 
        {
            this.numVertices = numVertices;
            adjList = new LinkedList[numVertices];

            for (int i = 0; i < numVertices ; i++) 
            {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int source, int destination){
            //add forward edge
            adjList[source].addFirst(destination);

            //add reverse edge
            adjList[destination].addFirst(source);
        }

        public boolean isCycle() {
            boolean result = false;

            //visited array
            boolean[] visited = new boolean[numVertices];

            //do DFS, from each vertex
            for (int i = 0; i < numVertices ; i++) {
                if(visited[i]==false){
                    if(isCycleUtil(i, visited, -1)){
                        return true;
                    }
                }
            }
            return result;
        }

        boolean isCycleUtil(int currVertex, boolean [] visited, int parent){

            //add this vertex to visited vertex
            visited[currVertex] = true;

            //visit neighbors except its direct parent
            for (int i = 0; i < adjList[currVertex].size() ; i++) 
            {
                int vertex = adjList[currVertex].get(i);
            
                //check the adjacent vertex from current vertex
                if(vertex != parent) 
                {
                    //if destination vertex is not its direct parent then
                    if(visited[vertex])
                    {
                        // if here means this destination vertex is already visited
                        // means cycle has been detected
                        return true;
                    }
                    else 
                    {
                        //recursion from destination node
                        if (isCycleUtil(vertex, visited, currVertex)) 
                        {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int numVertices = 6;
        Graph graph = new Graph(numVertices);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);

        boolean result = graph.isCycle();
        
        System.out.println("Is Cycle present: " + result);
    }
}