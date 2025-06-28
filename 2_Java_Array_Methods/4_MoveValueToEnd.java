import java.util.Scanner;
interface arr{
    int[] moveValue(int[] arr , int valu);
}
class arr_op implements arr{
    public int[] moveValue(int[] arr , int valu){
        int[] arr1 = new int[arr.length];
        int counter = 0 ;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]== valu)continue;
            arr1[counter++]= arr[i];
        }
        for (int j = counter; j < arr.length; j++) {
           arr1[j]= valu;
        }
        return arr1 ;
    }
}
public class lab2_4 {
    public static void main(String[] args) {
     Scanner scanf = new Scanner(System.in);
     int size = scanf.nextInt();
       int[] arr = new int[size];
       for (int i = 0; i < size; i++) {
         arr[i]=scanf.nextInt();
       }
       int valu = scanf.nextInt();
       arr_op move = new arr_op();
       int[] arr1 = move.moveValue(arr, valu);
       for (int i = 0; i < size; i++) {
       System.out.print(arr1[i]+" ");
       }
   
     }
    
 }
 