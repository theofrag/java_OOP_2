package packhw1.persons;

public abstract class Student extends Academic{

    Student(String name,int floorId,int classId){
        super(name,floorId,classId);
        System.out.println("A new Student has been created! ");
    }
    public abstract void attend(int hours);
    public void print() {
        System.out.println("Student's name is: "+ this.name + " and students fatigue is: "+ this.fatigue);
    }
 }