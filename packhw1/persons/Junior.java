package packhw1.persons;

public class Junior extends Student{

    private int Lj=0;
    public Junior(String name,int floorId,int classId,int L){
        super(name, floorId, classId);
        this.Lj=L;
    }
    public void attend(int hours) {
        for(int i=0;i<hours;i++)
        this.fatigue = this.fatigue + this.Lj;
    }
    

 }