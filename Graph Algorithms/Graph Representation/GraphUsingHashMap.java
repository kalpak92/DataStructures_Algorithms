import java.util.*;

public class GraphUsingHashMap {

    static class Graph 
    {
        HashMap<Object, LinkedList<Object>> adjList = new HashMap();
        HashMap<Object, Integer>  indexes = new HashMap<>();
        
        int index = -1;

        public Graph(ArrayList<Object> vertices) 
        {
            for (int i = 0; i <vertices.size() ; i++) {
                Object vertex = vertices.get(i);
                LinkedList<Object> list = new LinkedList<>();
                adjList.put(vertex, list);
                indexes.put(vertex, ++index);
            }
        }

        public void addEdge(Object source, Object destination) {
            //add forward edge
            LinkedList<Object> list;
            list = adjList.get(source);
            list.addFirst(destination);
            adjList.put(source, list);
        }

        public void DFS(){
            int vertices = adjList.size();
            boolean [] visited = new boolean[vertices];

            for (Map.Entry<Object, LinkedList<Object>> entry : adjList.entrySet()) 
            {
                Object source = entry.getKey();
                
                if(!visited[indexes.get(source)])
                {
                    DFSUtil(source, visited);
                }
            }
            System.out.println();
        }

        public void DFSUtil(Object source, boolean[] visited){

            //mark this visited
            visited[indexes.get(source)] = true;

            System.out.print(source + " ");

            LinkedList<Object> list = adjList.get(source);

            for (int i = 0; i <list.size() ; i++) 
            {
                Object destination = list.get(i);

                if(!visited[indexes.get(destination)])
                    DFSUtil(destination,visited);
            }
            
        }

        public void printGraph() {
            Set<Object> set = adjList.keySet();
            Iterator<Object> iterator = set.iterator();

            while(iterator.hasNext()){
                Object vertex = iterator.next();
                System.out.print("Vertex " + vertex + " is connected to: ");
                LinkedList<Object> list = adjList.get(vertex);
                for (int i = 0; i <list.size() ; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Object> vertices = new ArrayList<>();
        vertices.add('A');
        vertices.add('B');
        vertices.add('C');
        vertices.add('D');
        vertices.add('E');
        vertices.add('F');
        vertices.add('G');
        Graph graph = new Graph(vertices);
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'E');
        graph.addEdge('G', 'E');
        graph.addEdge('A', 'G');
        graph.printGraph();
        System.out.println("---------------Depth First Traversal------------");
        graph.DFS();
    }
}