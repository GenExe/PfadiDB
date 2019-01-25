package db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class Tasks {
    static List<Task> allTasks(Session session){
        Transaction transaction = null;
        List<Task> tasks = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Task");
            tasks = query.list();
            transaction.commit();
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
        }finally{
            session.close();
        }
        return tasks;
    }

    static List<Task> myTasks(Session session, Leader user){
        Transaction transaction = null;
        List<Task> tasks = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Task task " +
                    "left outer join fetch  task.leaderSet leaderSet where leaderSet.name = :code");
            query.setParameter("code", user.getName());
            tasks = query.list();
            transaction.commit();
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
        }finally {
            session.close();
            return tasks;
        }
    }

    static void print(Task e) {
        System.out.println("-----");
        System.out.println("Description: " + e.getName() + "   ID: " + e.getId());
        System.out.println("Info: " + e.getInfo());
        System.out.println("Due date: " + e.getDueDate());
        System.out.println("Task for: ");
        Set<Leader> leaders = e.getLeaderSet();
        for(Leader l : leaders){
            System.out.println(l.getName());
        }
        System.out.println("-----");
    }
}
