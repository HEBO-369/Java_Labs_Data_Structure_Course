import java.util.Scanner;
interface arr{
    double avarage(int[] arr);
}
class arr_op implements arr{
    public double avarage(int[] arr){
        int sum = 0 ;
        int z = arr.length ;
        if(z==0)return 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i]; 
        }
        return (float)sum/z ;
    }
}
public class lab2_3 {
   public static void main(String[] args) {
    Scanner scanf = new Scanner(System.in);
    int size = scanf.nextInt();
      int[] arr = new int[size];
      for (int i = 0; i < size; i++) {
        arr[i]=scanf.nextInt();
      }
      arr_op aver = new arr_op();
      System.out.print(aver.avarage(arr));
  
    }
   
}
