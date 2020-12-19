package packhw1.infrastructures;
import packhw1.persons.Student;
import packhw1.persons.Teacher;

public class Floor extends Trasplace{
    Classroom [] classrooms = new Classroom[6];
    Corridor corridor= new Corridor();
    int floorId;

    Floor(int Cclass, int floorId){
        for(int i=0;i<6;i++)
            this.classrooms[i]= new Classroom(Cclass, floorId, i);
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

        for(int i=0;i<6;i++){
            Student temp=this.classrooms[i].exit();
            if(temp==null)
                continue;
            else{
                System.out.println(temp.get_name()+ " starts exiting!");
                this.corridor.enter(temp);
                temp = this.corridor.exit();

                return temp;
            }
        }
        return null;
    }

}