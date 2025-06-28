import java.util.Scanner;
interface  fibo {
    int fibonacci1(int n );
}
class fibonacci implements fibo {
        public int fibonacci1(int n ){
            if(n==1) return 1 ;
            else if(n==0)return 0 ;
            else return (fibonacci1(n-1)+fibonacci1(n-2));
        }
}
public  class lab2_6{
    
   public static void main(String[] args) {
       Scanner scanf = new Scanner(System.in);
       int n = scanf.nextInt();
       fibonacci x = new fibonacci();
        System.out.print(x.fibonacci1(n-1));
    }

   }