/**
 * Graph is a collection of nodes or vertices (V) and edges(E) between them. We can traverse these nodes using the edges. 
 * These edges might be weighted or non-weighted.
 * 
 * Adjacency Matrix is 2-Dimensional Array which has the size VxV, where V are the number of vertices in the graph.
 * 
 * adjMaxtrix[i][j] = 1 when there is edge between Vertex i and Vertex j, else 0.
 * It’s easy to implement because removing and adding an edge takes only O(1) time.
 * But the drawback is that it takes O(V2) space even though there are very less edges in the graph.
 * 
 **/

 public class GraphAdjacencyMatrix
 {
    int vertex;
    int[][] matrix;

    public GraphAdjacencyMatrix(int vertex) 
    {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int source, int destination) 
    {
        //add edge
        matrix[source][destination]=1;

        //add bak edge for undirected graph
        matrix[destination][source] = 1;
    }

    public void printGraph() 
    {
        System.out.println("Graph: (Adjacency Matrix)");

        for (int i = 0; i < vertex; i++) 
        {
            for (int j = 0; j <vertex ; j++) 
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

        for (int i = 0; i < vertex; i++) 
        {
            System.out.print("Vertex " + i + " is connected to:");
            
            for (int j = 0; j <vertex ; j++) 
            {
                if(matrix[i][j]==1)
                {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5);
    
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        graph.printGraph();
    }
 }