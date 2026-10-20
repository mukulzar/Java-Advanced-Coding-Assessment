import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            Calculator obj = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            int a = 10;
            int b = 20;

            int sum = obj.add(a, b);
            int difference = obj.subtract(a, b);

            System.out.println("Sum: " + sum);
            System.out.println("Difference: " + difference);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
