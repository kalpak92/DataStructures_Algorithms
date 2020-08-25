import java.util.*;

public class GraphAdjacencyList {
    int vertex;
    LinkedList<Integer> list[];

    public GraphAdjacencyList(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){

        //add edge
        list[source].addFirst(destination);

        //add back edge ((for undirected)
        list[destination].addFirst(source);
    }

    public void printGraph(){
        for (int i = 0; i < vertex ; i++) {
            if(list[i].size() > 0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjacencyList GraphAdjacencyList = new GraphAdjacencyList(5);
        
        GraphAdjacencyList.addEdge(0, 1);
        GraphAdjacencyList.addEdge(0, 4);
        GraphAdjacencyList.addEdge(1, 2);
        GraphAdjacencyList.addEdge(1, 3);
        GraphAdjacencyList.addEdge(1, 4);
        GraphAdjacencyList.addEdge(2, 3);
        GraphAdjacencyList.addEdge(3, 4);

        GraphAdjacencyList.printGraph();
    }
}