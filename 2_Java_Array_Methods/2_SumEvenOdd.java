
import java.util.Scanner;
interface arr{
    int[] sumEvenOdd(int[] arr);
}
class arr_op implements arr{
    public int[] sumEvenOdd(int[] arr){
        int[] arr1 = new int[2];
        int sum1 = 0 ;
        int sum2 = 0 ;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0)
            sum1 += arr[i];
            else
            sum2 += arr[i];
        }
        arr1[0] = sum1;
        arr1[1] = sum2 ; 
        return arr1;
    }
}
public class lab2_2 {
   public static void main(String[] args) {
    Scanner scanf = new Scanner(System.in);
    int size = scanf.nextInt();
      int[] arr = new int[size];
      for (int i = 0; i < size; i++) {
        arr[i]=scanf.nextInt();
      }
      arr_op sum = new arr_op();
     int[] arr1 = sum.sumEvenOdd(arr) ;
     for (int i = 0; i < 2; i++) {
        System.out.print(arr1[i]+" ");
      }
    }
   
}

