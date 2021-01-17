package packhw1.infrastructures;
import packhw1.persons.Student;
import packhw1.persons.Teacher;

public class Floor extends Trasplace{
    Classroom [] classrooms = new Classroom[6]; //καθε οροφος εχει 6 ταξεις
    Corridor corridor= new Corridor();  //εναν διαδρομο
    int floorId;    //και ενα id που δειχνει ποιος οροφος ειναι

    Floor(int Cclass, int floorId){
        this.floorId=floorId;
        for(int i=0;i<6;i++)
            this.classrooms[i]= new Classroom(Cclass, floorId, i);
        System.out.println("A new Floor has been constructed");

    }
    public void enter(Student s){
        System.out.println(s.get_name()+ " enter Floor!");
        this.corridor.enter(s);
        if(this.classrooms[s.get_class_id()].available_space()==0)
            return;
        Student temp= this.corridor.exit();
        this.classrooms[temp.get_class_id()].enter(s);
    }

    public void operate(int hours){
        for(int i=0;i<6;i++)
            this.classrooms[i].operate(hours);
    }

    public void place(Teacher t){
        this.classrooms[t.get_class_id()].place(t);
    }
    public void print(){
        System.out.print("Floor number "+this.floorId+" contains: ");
        for(int i=0;i<6;i++)
            this.classrooms[i].print();
    }
    public Student exit(){

        for(int i=0;i<6;i++){   //Για καθε μια απο τις 6 ταξεις
            Student temp=this.classrooms[i].exit();    //Βγαζω τον μαθητη απο την ταξη
            if(temp==null)  //Αν επιστραφει null, σημαινει πως η ταξη δεν εχει αλλον μαθητη, αρα πηγαινω στην επομενη ταξη
                continue;
            else{
                System.out.println(temp.get_name()+ " starts exiting!");
                this.corridor.enter(temp);  //Βγηκε απο την ταξη, μπαινει στον οροφο
                temp = this.corridor.exit();    //Βγαινει απο το οροφο, εκτυπωνει μηνυμα.
                return temp;    //επιστρεφει τον μαθητη.
            }
        }
        return null;
    }

    public void teachers_out(){
        for(int i=0;i<6;i++)
            this.classrooms[i].teacher_out();
    }


}