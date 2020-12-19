package packhw1.infrastructures;
import packhw1.persons.Student;
import packhw1.persons.Teacher;


abstract class Trasplace{
    public abstract void operate(int hours);
    public abstract void enter(Student s);
    public abstract void place(Teacher t);


}