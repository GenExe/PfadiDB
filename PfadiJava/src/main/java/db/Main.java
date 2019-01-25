package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to PfadiDB Ver. 0.1.5");
        SessionFactory factory = SessionFactoryHelper.getSessionFactory();
        System.out.println("Enter username");
        Session session = factory.openSession();
        int check = Login.login(session, scan.nextLine());
        while (check != 0){
            System.out.println("Wrong username!");
            System.out.println("Enter username");
            check = Login.login(session, scan.nextLine());
        }
        session.close();
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
                    session = factory.openSession();
                    List<Event> myEvents = Events.myEvents(session, Login.getUser());
                    ListEvents(scan, myEvents);
                    break;

                case "my tasks":
                    session = factory.openSession();
                    List<Task> myTasks = Tasks.myTasks(session, Login.getUser());
                    ListTasks(scan, myTasks);
                    break;

                case "my invitations":
                    session = factory.openSession();
                    List<Invitation> myInvitations = Invitations.myInvitations(session, Login.getUser());
                    ListInvitations(scan, myInvitations);
                    break;

                case "my groups":
                    session = factory.openSession();
                    List<Group> myGroups = Groups.myGroups(session, Login.getUser());
                    ListGroups(scan, myGroups);
                    break;

                case "all events":
                    session = factory.openSession();
                    List<Event> events = Events.allEvents(session);
                    ListEvents(scan, events);
                    break;

                case "all resources":
                    session = factory.openSession();
                    List<Resource> resources = Resources.allResources(session);
                    ListResources(scan, resources);
                    break;

                case "all leaders":
                    session = factory.openSession();
                    List<Leader> leaders = Leaders.allLeaders(session);
                    ListLeaders(scan, leaders);
                    break;

                case "all groups":
                    session = factory.openSession();
                    List<Group> groups = Groups.allGroups(session);
                    ListGroups(scan, groups);
                    break;

                case "new event":
                    //todo: event creation
                    break;

                case "new task":
                    //todo: task creation
                    break;

                case "new group":
                    //todo: group creation
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("no valid input");
                    scan.nextLine();
                    break;
            }
        }
        Login.logout();
        scan.close();
        System.out.println("Exit PfadiDB");
        System.exit(0);
    }

    private static void ListEvents(Scanner scan, List<Event> events) {
        if(events.isEmpty()) {
            System.out.println("No events found");
        }
        else {
            int i = 0;
            for (Event e: events) {
                i++;
                System.out.println(i + ": " + e.getName());
            }
            System.out.println("Enter corresponding number for event details");
            int in = scan.nextInt();
            if (in > 0 && in <= i) {
                Events.print(events.get(in-1));
            } else {
                System.out.println(in + " is no valid input");
                scan.nextLine();
            }
        }
        System.out.println();
    }

    private static void ListLeaders(Scanner scan, List<Leader> leaders) {
        if(leaders.isEmpty()) {
            System.out.println("No leaders found");
        }
        else {
            int i = 0;
            for (Leader e: leaders) {
                i++;
                System.out.println(i + ": " + e.getName());
            }
            System.out.println("Enter corresponding number for leader details");
            int in = scan.nextInt();
            if (in > 0 && in <= i) {
                Leaders.print(leaders.get(in-1));
            } else {
                System.out.println(in + " is no valid input");
                scan.nextLine();
            }
        }
        System.out.println();
    }

    private static void ListTasks(Scanner scan, List<Task> tasks) {
        if(tasks.isEmpty()) {
            System.out.println("No tasks found");
        }
        else {
            int i = 0;
            for (Task e: tasks) {
                i++;
                System.out.println(i + ": " + e.getName());
            }
            System.out.println("Enter corresponding number for task details");
            int in = scan.nextInt();
            if (in > 0 && in <= i) {
                Tasks.print(tasks.get(in-1));
            } else {
                System.out.println(in + " is no valid input");
                scan.nextLine();
            }
        }
        System.out.println();
    }

    private static void ListGroups(Scanner scan, List<Group> groups) {
        if(groups.isEmpty()) {
            System.out.println("No groups found");
        }
        else {
            int i = 0;
            for (Group e: groups) {
                i++;
                System.out.println(i + ": " + e.getName());
            }
            System.out.println("Enter corresponding number for group details");
            int in = scan.nextInt();
            if (in > 0 && in <= i) {
                Groups.print(groups.get(in-1));
            } else {
                System.out.println(in + " is no valid input");
                scan.nextLine();
            }
        }
        System.out.println();
    }

    private static void ListResources(Scanner scan, List<Resource> resources) {
        if(resources.isEmpty()) {
            System.out.println("No resources found");
        }
        else {
            int i = 0;
            for (Resource e: resources) {
                i++;
                System.out.println(i + ": " + e.getName());
            }
            System.out.println("Enter corresponding number for resource details");
            int in = scan.nextInt();
            if (in > 0 && in <= i) {
                Resources.print(resources.get(in-1));
            } else {
                System.out.println(in + " is no valid input");
                scan.nextLine();
            }
        }
        System.out.println();
    }

    private static void ListInvitations(Scanner scan, List<Invitation> invitations) {
        if(invitations.isEmpty()) {
            System.out.println("No invitations found");
        }
        else {
            int i = 0;
            for (Invitation e: invitations) {
                i++;
                System.out.println(i + ": " + e.getEvent().getName());
            }
            System.out.println("Enter corresponding number for invitation details");

            int in = scan.nextInt();
            if (in > 0 && in > 0 && in <= i) {
                Invitations.print(invitations.get(in-1));
                System.out.println("Type yes to accept, no to decline or anything else to decide later");
                String accept = scan.nextLine();
                switch(accept) {
                    case "yes":
                        //todo: update accepted = true
                        break;

                    case "no":
                        //todo: update accepted = false
                        break;

                    default:
                        System.out.println("no valid input");
                        scan.nextLine();
                        break;
                }
            } else {
                System.out.println("no valid input");
                scan.nextLine();
            }
        }
        System.out.println();
    }
}
