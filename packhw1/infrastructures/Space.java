package packhw1.infrastructures;
import packhw1.persons.Student;
import java.util.LinkedList;

public abstract class Space{
    
    protected LinkedList <Student> students = new LinkedList <Student>();
    public abstract void enter (Student s);
    public abstract Student exit();

}