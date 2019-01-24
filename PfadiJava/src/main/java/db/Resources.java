package db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Resources {
    static List<Resource> allResources(Session session){
        Transaction transaction = null;
        List<Resource> resources = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Resource");
            resources = query.list();
            transaction.commit();
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
        }finally{
            session.close();
        }
        return resources;
    }

    static void print(Resource e) {
        System.out.println("-----");
        System.out.println("Name: " + e.getName());
        System.out.println("Info: " + e.getInfo());
        System.out.println("ID: " + e.getResId());
        System.out.println("-----");
    }
}
