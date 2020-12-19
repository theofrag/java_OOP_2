package packhw1.infrastructures;
import packhw1.persons.Student;

public class Stairs extends Space{

    Stairs(){
        System.out.println("A new Stairs has been constructed");
    }
    public void enter(Student s){
        this.students.add(s);
        System.out.println(s.get_name()+ " enter Stairs!");
    }
    
    public Student exit(){
        
        Student temp = students.getLast();
        System.out.println(temp.get_name()+ " exits Stairs!"); 
        students.removeLast();
        return temp;
    }
}