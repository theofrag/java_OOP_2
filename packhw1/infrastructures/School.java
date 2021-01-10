package packhw1.infrastructures;
import packhw1.persons.Student;
import packhw1.persons.Teacher;

public class School extends Trasplace{

    private SchoolYard schoolyard = new SchoolYard() ;
    private Stairs stairs = new Stairs();
    private Floor[] floors= new Floor[3];

    public School(int Cclass){
        for(int i=0;i<3;i++)
            floors[i]=new Floor(Cclass, i);
        System.out.println("A new School has been constructed");
    }

    public void place(Teacher t){
        this.floors[t.get_floor_id()].place(t);
    }

    public void operate(int hours){
        for(int i=0;i<3;i++)
            this.floors[i].operate(hours);
    }

    public void enter(Student s){
        System.out.println(s.get_name()+ " enters School!");
        this.schoolyard.enter(s);
        this.stairs.enter(this.schoolyard.exit());
        Student temp= this.stairs.exit();
        this.floors[temp.get_floor_id()].enter(temp);
    }

    public void print(){
        System.out.print("School life consist of: " );
        for (int i=0;i<3;i++)
            this.floors[i].print();
    }

    public void empty(){
        for(int i=0;i<3;i++){   //Για καθε οροφο 0,1,2
            Student temp = this.floors[i].exit();   //Καλω την exit του οροφου
            while(temp!=null){  //Aν γινει null ο i οροφος, δεν εχει αλλους μαθητες
                this.stairs.enter(temp);    //Αφου ο μαθητης βγηκε απο τον οροφο, μπαινει στις σκαλες
                temp=this.stairs.exit();    //βγαινει απο τις σκαλες, μπαινει στο προαυλιο
                this.schoolyard.enter(temp);    
                temp = this.schoolyard.exit();  //βγαινει απο το προαυλιο
                temp=this.floors[i].exit(); //βγαζω τον επομενο μαθητη που ειναι η σειρα του να βγει
            }
        }

        for(int i=0;i<3;i++)    //Τελος βγαζω τους δασκαλους
            this.floors[i].teachers_out();
    }

}