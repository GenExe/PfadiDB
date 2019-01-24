package db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Groups {
    static List<Group> allGroups(Session session){
        Transaction transaction = null;
        List<Group> groups = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Group");
            groups = query.list();
            transaction.commit();
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
        }finally{
            session.close();
            return groups;
        }
    }

    static List<Group> myGroups(Session session, String username){
        Transaction transaction = null;
        List<Group> groups = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Group group " +
                    "left outer join fetch  group.leaderSet leaderSet where leaderSet.name = :code");
            query.setParameter("code", username);
            groups = query.list();
            transaction.commit();
        }catch(Exception e){
            if (transaction!= null) transaction.rollback();
        }finally {
            session.close();
        }
        return groups;
    }

    static void print(Group e) {
        System.out.println("-----");
        System.out.println(e.getName());
        System.out.println("ID: " + e.getId());
        System.out.println("Membercoun: " + e.getMemberCount());
        System.out.println("-----");
    }
}
