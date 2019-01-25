package db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Login {
    private static Leader current;

    static Leader getUser(){
        return current;
    }

    static int login(Session session, String username){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Leader leader where leader.name = :code");
            query.setParameter("code", username);
            current =(Leader) query.getSingleResult();
            transaction.commit();
            return 0;
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
            return -1;
        }

    }

    static void logout(){
        current = null;
        System.out.println("Logout successful");
    }
}
