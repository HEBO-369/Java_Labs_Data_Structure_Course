import java.util.Scanner;
interface  trans {
    int[][] transpose(int[][] arr);
}
class matrix implements trans {
    public int[][] transpose(int[][] arr ){
        int[][] arr1  = new int[arr[0].length][arr.length] ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr1[j][i] = arr[i][j]; 
                
            }
        }
       return arr1;
    }
}
public  class lab2_5{
   public static void main(String[] args) {
       Scanner scanf = new Scanner(System.in);
       int length = scanf.nextInt();
       int width = scanf.nextInt();
       int[][] arr = new int [length][width] ;
       for (int i = 0; i < length ; i++) {
        for (int j = 0; j < width ; j++) {
            arr[i][j] = scanf.nextInt(); 
        }
    }
    matrix tran = new matrix();
    int[][] matrix1 = tran.transpose(arr);
    for (int i = 0; i < width ; i++) {
        for (int j = 0; j < length ; j++) {
            System.out.print(matrix1[i][j]+" ");; 
        }
        System.out.print("\n");
    }

   }
}