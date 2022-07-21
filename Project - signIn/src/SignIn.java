import java.util.Hashtable;
import java.util.Scanner;
public class SignIn {
    Hashtable<String,String> users = new Hashtable<String, String>();
    Hashtable<String,String> usersWq = new Hashtable<String, String>();
    public void signUp(Scanner scanner){
        boolean created = false;
        System.out.println("Enter a UserName");
        String username = scanner.nextLine();
        while(users.containsKey(username)){
            System.out.println("The Username already exists, Choose a Username (you can only use NUMBERS & ALPHABETS):");
            username = scanner.nextLine();
        }
        System.out.println("Answer the questions below:");
        System.out.println("What is your favorite animal?");
        String security = scanner.nextLine();
        System.out.println("When is your birthday?");
        String birtDay = scanner.nextLine();
        while(!created) {
            System.out.println("Enter a Password:");
            String password = scanner.nextLine();
            while (password.length() < 8 || !password.matches("([A-Z1-9])\\w+")) {
                if (password.length() < 8)
                    System.out.println("Password too short, Choose a Password:");
                if (!password.matches("([A-Z1-9])\\w+"))
                    System.out.println("Wrong characters are used, Choose a Password:");
                password = scanner.nextLine();
            }
            System.out.println("Enter your Password again:");
            String passwordCheck = scanner.nextLine();
            if (password.matches(passwordCheck)) {
                System.out.println("Account created successfully");
                users.put(username, password);
                usersWq.put(username, security);
                // User user = new User(username, password, security, birthDay);
                created = true;
                // حالا وارد اکانتش بشه
            }
            System.out.println("Password not matched, Try again");
        }
    }
    public void login (Scanner scanner){
        boolean signedIn = false;
        System.out.println("Forget your Password? 1.No 2.Yes");
        int check = scanner.nextInt();
        scanner.nextLine();
        if (check == 2){
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
            System.out.println("What is your favorite animal?");
            String answer = scanner.nextLine();
            if(!usersWq.get(username).matches(answer)) {
                System.out.println("Wrong answer");
                //todo خب بعدش چی؟
            }
            else{
                System.out.println("Change your Password, Choose a new Password:");
                String password = scanner.nextLine();
                while (password.length() < 8 || !password.matches("([A-Z1-9])\\w+")) {
                    if (password.length() < 8)
                        System.out.println("Password too short, Choose a Password:");
                    if (!password.matches("([A-Z1-9])\\w+"))
                        System.out.println("Wrong characters are used, Choose a Password:");
                        password = scanner.nextLine();
                }
                users.replace(username,password);
                System.out.println("Password changed successfully");
                System.out.println("Try to logIn using your new Password");

            }
        }
        while (!signedIn) {
            System.out.println("Enter your username:");
            String username = scanner.nextLine();
                System.out.println("Enter your Password:");
                String password = scanner.nextLine();
                if (!users.containsKey(username))
                    System.out.println("No account exists with this username");
                else if (!users.get(username).matches(username))
                    System.out.println("Wrong Password");
                if (users.get(username).matches(password)) {
                    signedIn = true;
                    System.out.println("Logged in successfully");
                    // برو تو اکانت!
                }
            System.out.println("please try again.");
        }
    }
}
