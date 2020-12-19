package packhw1.infrastructures;
import packhw1.persons.Student;

public class Corridor extends Space{

    Corridor(){
        System.out.println("A new Corridor has been constructed");
    }
    public void enter(Student s){
        this.students.add(s);
        System.out.println(s.get_name()+ " enter Corridor!");
    }
    
    public Student exit(){
        Student temp = students.getLast();
        System.out.println(temp.get_name()+ " exits Corridor!"); 
        students.removeLast();
        return temp;
    }
}