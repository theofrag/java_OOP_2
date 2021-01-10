package packhw1.infrastructures;
import packhw1.persons.Student;
import packhw1.persons.Teacher;
import java.util.LinkedList;

public class Classroom extends Trasplace{

    private int Cclass; //Χωρητικοτητα ταξης
    private int floorId;    //Αριθμος οροφου που ανηκει η ταξη
    private int classId;    //αριθμος ταξης
    private Teacher teacher; 
    private LinkedList <Student> students =new LinkedList <Student>();  //αποθηκευει τους μαθητες της ταξης

    Classroom(int C,int floorId, int classId){
        this.Cclass=C;
        this.floorId=floorId;
        this.classId = classId;
        System.out.println("A new Classroom has been constructed");
    }
    
    public void enter(Student s){
        if(this.students.size() == Cclass)
            return;
        this.students.add(s);
        s.set_inClass(true);
        System.out.println(s.get_name()+ " enters Classroom");
        
    }

    public void place(Teacher t){
        if(this.teacher== null){
            this.teacher=t;
            t.set_inClass(true);
        }
    }
    public void operate(int hours){
        for(int i=0; i<this.students.size(); i++ ){
            this.students.get(i).attend(hours);
        }
        if(this.teacher!=null)
            this.teacher.teach(hours);
    }

    public void print(){
        System.out.println("People in class "+ this.floorId + "."+ this.classId + " are: ");
        for(int i=0;i<this.students.size();i++)
            this.students.get(i).print();
        if(this.teacher!=null)
            teacher.print();
    }

    public Student exit(){

        if(this.students.size()==0)
            return null;

       this.students.getLast().set_inClass(false);
       System.out.println(this.students.getLast().get_name()+ " exits Classroom!");
       return this.students.removeLast();

    }
    
    public int available_space(){
        return this.Cclass - this.students.size();
    }

    public void teacher_out(){
        if(this.teacher==null)
            return;
        System.out.println(this.teacher.get_name()+ " teacher is out!");
        this.teacher.set_inClass(false);
        this.teacher=null;

    }

}