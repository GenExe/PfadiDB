package db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Events{

    static List<Event> allEvents(Session session) {
        Transaction transaction = null;
        List<Event> events = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Event");
            events = query.list();
            transaction.commit();
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
        }finally{
            session.close();
            return events;
        }
    }

    static void print(Event e) {
        System.out.println("-----");
        System.out.println(e.getName());
        System.out.println("von " + e.getStartdate() + " bis " + e.getEnddate());
        System.out.println(e.getInfo());
        System.out.println("-----");
    }
}
