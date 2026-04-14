import java.util.Scanner;

public class BasicOutputs_Sequencing {
    public static void main(String[] args) {
    // Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("\nPlease enter limit: ");

        // Read the integer input
        int limit = scanner.nextInt();

        // Print the entered value
        System.out.println("You entered: " + limit);
int num1 = 0;
int num2 = 1;
        do{
            num1 = num1 + num2;
            System.out.println(num1);
num2 = num1 + num2;
System.out.println(num2);

        }
        while ( num1+num2< limit);
        // Close the scanner
        scanner.close();

    }
}