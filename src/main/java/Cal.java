import java.util.Scanner;

public class Cal {
    public static double addMe(double a, double b) {
        return a + b;
    }
    public static double subMe(double a, double b) {
        return a - b;
    }
    public static double mulMe(double a, double b) {
        return a * b;
    }
    public static double divMe(double a, double b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("first no");
        double a = sc.nextDouble();
        System.out.println("second no");
        double b = sc.nextDouble();

        System.out.println("Add me "+addMe(a,b));
        System.out.println("Sub me "+subMe(a,b));
        System.out.println("Mul me "+mulMe(a,b));
        System.out.println("Div me "+divMe(a,b));


    }
}
