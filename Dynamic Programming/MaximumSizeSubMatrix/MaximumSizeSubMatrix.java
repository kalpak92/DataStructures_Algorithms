public class MaximumSizeSubMatrix {

    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    public int maxSize(int arr[][]){
        
        int result[][] = new int[arr.length][arr[0].length];
        int max = 0;

        // Initialize the first row and first column
        for(int i=0; i < arr.length; i++){
            result[i][0] = arr[i][0];
            if (result[i][0] == 1)
            {
                max = 1;
            }
        }
        
        for(int i=0; i < arr[0].length; i++){
            result[0][i] = arr[0][i];
            if (result[0][i] == 1)
            {
                max = 1;
            }
            
        }

        // Now for the rest of the matrix
        // For each element matrix[i][j], 
        // if matrix[i][j] == 1
        //      find the minimum of immediate left, top, diagonal and add 1 to it.
        
        for(int i=1; i < arr.length; i++){
            for(int j=1; j < arr[i].length; j++){
                if(arr[i][j] == 0){
                    continue;
                }
                int t = min(result[i-1][j],result[i-1][j-1],result[i][j-1]);
                result[i][j] =  t +1;
                if(result[i][j] > max){
                    max = result[i][j];
                }
            }
        }
        return max*max;
    }
    
    
    public static void main(String args[]){
        
        int arr[][] = {{0,1,1,0,1},{1,1,1,0,0},{1,1,1,1,0},{1,1,1,0,1}};
        MaximumSizeSubMatrix mssm = new MaximumSizeSubMatrix();
        int result = mssm.maxSize(arr);
        System.out.println(result);
    }
    
}