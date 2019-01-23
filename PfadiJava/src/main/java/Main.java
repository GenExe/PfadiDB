import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to PfadiDB Ver. 0.1.5");
        SessionFactory factory = null;
        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        configuration.addAnnotatedClass(Event.class);
        configuration.addAnnotatedClass(Group.class);
        configuration.addAnnotatedClass(Invitation.class);
        configuration.addAnnotatedClass(Leader.class);
        configuration.addAnnotatedClass(Resource.class);
        configuration.addAnnotatedClass(Task.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(registry);
//        System.out.println("Enter username");
//        int check = Login.login(scan.nextLine());
//        while (check != 0){
//            System.out.println("Wrong username!");
//            System.out.println("Enter username");
//            check = Login.login(scan.nextLine());
//        }
//        System.out.println("Logged in as " + Login.getUser().getName());
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
                    List<Event> events = Events.allEvents();
                    System.out.println(Enter corresponding number for event details, 0 to exit command);
                    int i = 0;
                    for (e: events) {
                        i++;
                        System.out.println(i + ": " + e.getName);
                    }
                    int in = scan.nextInt();
                    while(in != 0) {
                        if (in > 0 && in <= i) {
                            Events.print(e);
                        } else {
                            System.out.println("no such Event");
                        }
                        in = scan.nextInt();
                    }

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
