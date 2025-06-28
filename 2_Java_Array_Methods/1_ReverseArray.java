import java.util.Scanner;
interface arr{
    int[] reverse(int[] arr);
}
class Solution implements arr{
    public int[] reverse(int[] arr){
        int[] arr1 = new int[arr.length];
        int z = arr.length ;
        for (int i = 0; i < arr.length; i++) {
            arr1[i]= arr[--z]; 
        }
        return arr1;
    }
}
public class lab2_1 {
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");;
		int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
        	   arr[i] = Integer.parseInt(s[i]);
        }
      	int[] res = new Solution().reverse(arr);
     	System.out.print("[");
      	for(int i = 0; i < res.length; ++i) {
        	System.out.print(res[i]);
            if(i != s.length - 1)
              System.out.print(", ");
        }
        System.out.print("]");
    }
}
