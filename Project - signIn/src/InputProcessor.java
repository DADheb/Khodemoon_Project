import java.util.Scanner;

public class InputProcessor {
    static SignIn signIn;
    public static void main(String[] args) {
        signIn = new SignIn();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a number:");
        System.out.println("1. SignUp");
        System.out.println("2. LogIn");
        int command = scanner.nextInt();
        scanner.nextLine();
        if(command == 1)
            signIn.signUp(scanner);
        else
            signIn.login(scanner);
    }
}
