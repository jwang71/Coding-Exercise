public class HelloWorld{
     public static void main(String []args){
        int[][] b = {{1,1},{1,0}};
        int[][] c = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        gameOfLife(c);
       for (int i=0;i < c.length; i++) {
            System.out.println("Row: " + i);
           
           for (int j = 0; j < c[0].length;j++) {
                System.out.println(c[i][j]);               
           }
       }

     }
     
    public static void gameOfLife(int[][] board) {
        int m = board.length;  
        int n = board[0].length;
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            //System.out.println("Row: " + i);
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (i-1>=0 && j-1>=0 && board[i-1][j-1] == 1) {
                    count++;
                }
                if (i-1>=0 && j>= 0&&board[i-1][j] == 1) {
                    count++;
                }
                if (i-1>=0 && j+1<=n-1 &&board[i-1][j+1] == 1) {
                    count++;
                }
                if (i>=0 && j-1>= 0&&board[i][j-1] == 1) {
                    count++;
                }
                if (i>=0 && j+1<= n-1&&board[i][j+1] == 1) {
                    count++;
                }
                if (i+1<=m-1 && j-1>=0 &&board[i+1][j-1] == 1) {
                    count++;
                }
                if (i+1<=m-1 && j>=0 &&board[i+1][j] == 1) {
                    count++;
                }
                if (i+1<=m-1 && j+1<=n-1 &&board[i+1][j+1] == 1) {
                    count++;
                }
               
            //   System.out.println(count); 
                if (count <= 2) {
                   res[i][j] = 0; 
                } else if (count > 3) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i< m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
}