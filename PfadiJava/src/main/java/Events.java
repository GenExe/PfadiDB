import javax.management.Query;
import java.util.List;

public class Events{

    static List<Event> allEvents() {
        List<Event> events;
        Session session = factory.openSession();
        Query query = session.createNativeQuery("SELECT * FROM event");
        List<> list = query.list();
        for (row: list) {
            Event e = ;//todo: row.toPojo
            events.add(e);
        }
        return events;
    }

    static print(Event e) {
        System.out.println("-----");
        System.out.println(e.getName());
        System.out.println("von " + e.getStartdate() + " bis " + e.getEnddate());
        System.out.println(e.getInfo());
        System.out.println("-----");
    }
}
