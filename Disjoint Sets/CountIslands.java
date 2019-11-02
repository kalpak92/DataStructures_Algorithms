/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 *
 * * * * * * * * * * * * * * * 
 * ALGORITHM 
 * Traverse the 2d grid map and union adjacent lands horizontally or vertically, 
 * at the end, return the number of connected components maintained in the UnionFind data structure.
 */

class CountIslands {
    int[][] distance = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)  
        {
            return 0;  
        }
        
        UnionFind uf = new UnionFind(grid);  
        
        int rows = grid.length;  
        int cols = grid[0].length;  
        
        for (int i = 0; i < rows; i++) 
        {  
            for (int j = 0; j < cols; j++) 
            {  
                if (grid[i][j] == '1') 
                {  
                    for (int[] d : distance) 
                    {
                        int x = i + d[0];
                        int y = j + d[1];
                        
                        //System.out.println("x = " + x + " y = " + y);
                        
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') 
                        {  
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            
                            //System.out.println("x = " + x + " y = " + y + " id1 = " + id1 + " id2 = " + id2);
                            uf.union(id1, id2);  
                        }  
                    }  
                }  
            }  
        }  
        return uf.getCount();  
    }

    public static void main(String[] args) {
        CountIslands ci = new CountIslands();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        
        System.out.println("Number of islands = " + ci.numIslands(grid));
    }
}
    
    
class UnionFind
{
    private int[] father;
    private int count = 0;

    public UnionFind(char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        father = new int [m*n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == '1')
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

    public int getCount()
    {
        return count;
    }
}