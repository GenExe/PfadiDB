import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to PfadiDB Ver. 0.1.5");
        System.out.println("Enter username");
        int check = Login.login(scan.nextLine());
        while (check != 0){
            System.out.println("Wrong username!");
            System.out.println("Enter username");
            check = Login.login(scan.nextLine());
        }
        System.out.println("Logged in as " + Login.getUser().getName());
        boolean running = true;
        String input;
        while(running) {
            System.out.println("Enter command");
            System.out.println("my [events | tasks | invitations | groups]");
            System.out.println("all [events | resources | leaders | groups]");
            System.out.println("new [event | task | group]");
            System.out.println("exit");
            input = scan.nextLine();
            switch (input) {
                case "my events":
                    //todo: list events for the user
                case "my tasks":
                    //todo: list tasks for the user
                case "my invitations":
                    //todo: list invitations for the user
                case "my groups":
                    //todo: list groups for the user
                case "all events":
                    //todo: list all events
                case "all resources":
                    //todo: list all resources
                case "all leaders":
                    //todo: list all leaders
                case "all groups":
                    //todo: list all groups
                case "new event":
                    //todo: event creation
                case "new task":
                    //todo: task creation
                case "new group":
                    //todo: group creation
                case "exit":
                    running = false;
                default:
                    running = false;
            }
        }
        Login.logout();
        scan.close();
        System.out.println("Exit PfadiDB");
    }
}
