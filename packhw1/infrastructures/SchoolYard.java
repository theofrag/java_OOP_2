package packhw1.infrastructures;
import packhw1.persons.Student;

public class SchoolYard extends Space{

    SchoolYard(){
        System.out.println("A new SchoolYard has been constructed");
    }
    public void enter(Student s){
        this.students.add(s);
        System.out.println(s.get_name()+ " enter SchoolYard!");
    }
    
    public Student exit(){
        
        Student temp = students.getLast();
        System.out.println(temp.get_name()+ " exits SchoolYard!"); 
        students.removeLast();
        return temp;
    }
}