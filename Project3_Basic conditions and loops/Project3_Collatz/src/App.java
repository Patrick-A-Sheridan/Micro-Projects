import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Please enter a number: ");
        Scanner sc = new Scanner(System.in);
        int Startval = sc.nextInt();
     do{
         if (Startval % 2 == 0) {
             Startval /= 2;
             System.out.println(Startval);
         }
         else if (Startval%2 != 0) {
             Startval = Startval * 3 + 1;
                       System.out.println(Startval);
         }
    }
    while (Startval != 1); 
    
     
    }
}
