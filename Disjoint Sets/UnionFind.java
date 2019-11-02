public class UnionFind
{
    private int[] father;
    private int count = 0;

    public UnionFind(String[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        father = new int [m*n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == "1")
                {
                    int id = i*n + j;
                    father[id] = id;
                    count ++;
                }
            }
        }
    }

    public void union(int node1, int node2)
    {
        int find1 = find(node1);
        int find2 = find(node2);

        if(find1 != find2)
        {
            father[find1] = find2;
            count --;
        }
    }

    public int find(int node)
    {
        if(father[node] == node)
            return node;

        father [node] = find(father[node]);
        return father[node];
    }

    public void displayFather()
    {
        for(int i = 0; i < father.length; i++)
            System.out.print(father[i] + " ");
        
        System.out.println();
    }
    
    public void getCount()
    {
        System.out.println(count);
    }



    public static void main(String[] args) {
        String[][] grid = {{"1","1","1","1","0"},{"1","1","0","1","0"},{"1","1","0","0","0"},{"0","0","0","0","0"}};
        
        UnionFind uf = new UnionFind(grid);

        uf.displayFather();
        uf.getCount();
        uf.union(2, 3);
        uf.displayFather();
        System.out.println("Find 2: " + uf.find(2));
        uf.displayFather();
        uf.getCount();
    }
}