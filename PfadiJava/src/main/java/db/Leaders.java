package db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class Leaders {
    static List<Leader> allLeaders(Session session){
        Transaction transaction = null;
        List<Leader> leaders = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Leader ");
            leaders = query.list();
            transaction.commit();
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
        }finally{
            session.close();
        }
        return leaders;
    }

    static void print(Leader e) {
        System.out.println("-----");
        System.out.println("Name: " + e.getName());
        System.out.println("ID: " + e.getId());
        Set<Group> groups = e.getGroupSet();
        System.out.println("In Group:");
        for(Group g : groups){
            System.out.println(g.getName());
        }
        System.out.println("-----");
    }
}
