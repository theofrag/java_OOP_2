package packhw1.persons;

public class Teacher extends Academic{

    private int Lt=0;
    public Teacher(String name, int floorId, int classId, int L){
        super(name, floorId, classId);
        this.Lt=L;
        System.out.println("A New Teacher has been created!");
    }

    public void print() {
        System.out.println("Teacher's name is: "+ this.name + " and teacher fatigue is: "+ this.fatigue);
    }

    public void teach(int hours){
        for(int i=0;i<hours;i++)
        this.fatigue = this.fatigue + this.Lt;
    }
 }