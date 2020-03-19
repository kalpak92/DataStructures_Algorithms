import java.util.ArrayList;
import java.util.Stack;

/**
 * The algorithm Kosaraju's algorithm works as follows:
 * 
 * Let G be a directed graph and S be an empty stack.
 *  While S does not contain all vertices:
 *      Choose an arbitrary vertex ''v'' not in S. 
 *      Perform a depth first search starting at ''v''. 
 *         Each time that depth-first search finishes expanding a vertex ''u'', push ''u'' onto S.
 *      Reverse the directions of all arcs to obtain the transpose graph.
 * 
 *      While S is nonempty:
 *          Pop the top vertex ''v'' from S. 
 *          Perform a depth-first search starting at ''v'' in the transpose graph. 
 *          The set of visited vertices will give the strongly connected component containing ''v''; record this and remove all these vertices from the graph G and the stack S. 
 * 
 *  Equivalently, breadth-first search (BFS) can be used instead of depth-first search.
 **/

public class  {
	
	static int N;
	static ArrayList<Integer>[] adjList, adjListR, graph;
	static Stack<Integer> stack;
	static boolean[] visited;
	static int SCC;
	
	
	public static int SCC()
	{
		stack = new Stack<Integer>();
		visited = new boolean[N];
		graph = adjList;
		for(int i = 0; i < N; ++i)
			if(!visited[i])
				dfs(i, true);
		
		visited = new boolean[N];
		graph = adjListR;
		SCC = 0;
		while(!stack.isEmpty())
		{		
			int u = stack.pop();
			if(!visited[u])
			{
				SCC++;
				dfs(u, false);
			}
			//if visited then this vertex belongs to the SCC of the vertex which visited it		
		}
		
		return SCC;
	}
	
	public static void dfs(int u, boolean fillingStack)
	{
		visited[u] = true;
		for(int v: graph[u])
			if(!visited[v])
				dfs(v, fillingStack);
		if(fillingStack)
			stack.push(u);
	}
}