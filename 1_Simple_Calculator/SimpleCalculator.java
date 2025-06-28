import java.util.Scanner;
interface ICalculator {
    int add(int x, int y);
    float div(int x, int y);
}
class Calculator implements ICalculator {
    public int add(int x, int y) {
        return x + y;
    }
    public float div(int x, int y) {
        return (float) x / y;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        int x, y;
        String s;
        char z;
        x = scanf.nextInt();
        s = scanf.next();
        z = s.charAt(0);
        y = scanf.nextInt();
        Calculator calc = new Calculator();
            if (z == '+') {
                System.out.print(calc.add(x, y));
            } else if (z == '/' && y != 0 ) {
                System.out.print(calc.div(x, y));
            } else {
                System.out.print("Error");
            }
    }
}