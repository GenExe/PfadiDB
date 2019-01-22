import org.hibernate.query.Query;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        String hql = "FROM leader";
        Query query = session.createQuery(hql);
        List results = query.list();
    }
}
