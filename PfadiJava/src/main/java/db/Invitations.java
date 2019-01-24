package db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class Invitations {
    static List<Invitation> allInvitations(Session session){
        Transaction transaction = null;
        List<Invitation> invitations = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Invitation");
            invitations = query.list();
            transaction.commit();
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
        }finally{
            session.close();
            return invitations;
        }
    }

    static List<Invitation> myInvitations(Session session, String username){
        Transaction transaction = null;
        List<Invitation> invitations = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Invitation where Invitation.leader = :code");
            query.setParameter("code", username);
            invitations = query.list();
            transaction.commit();
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
        }finally {
            session.close();
        }
        return invitations;
    }

    static void print(Invitation e) {
        System.out.println("-----");
        System.out.println("Invitation for: " + e.getEvent().getName());
        System.out.println("To: " + e.getLeader().getName());
        System.out.println("ID: " + e.getInvitationId());
        System.out.println("-----");
    }
}
