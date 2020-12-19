package packhw1.persons;

public class Senior extends Student{

    private int Ls=0;
    public Senior(String name,int floorId,int classId,int L){
        super(name, floorId, classId);
        this.Ls=L;
    }
    public void attend(int hours) {
        for(int i=0;i<hours;i++)
            this.fatigue = this.fatigue + this.Ls;
    }
 }