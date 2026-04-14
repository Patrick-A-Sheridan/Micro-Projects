   import java.util.Scanner;
public class BasicOutputs1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!\n Please enter a number, I'll double it");


        Scanner scanner = new Scanner(System.in);
        String StringNumber= scanner.nextLine();
           int intNumber = Integer.valueOf(StringNumber);
            System.out.print(intNumber*2);
    }
}