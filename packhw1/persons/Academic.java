package packhw1.persons;



public abstract class Academic extends Human{

    protected int floorId, classId; //αριθμος οροφου, αριθμος αιθουσας
    protected boolean inClassroom=false; //αν ειναι στην ταξη του == true
    protected int fatigue=0;

    Academic(String name, int floorId, int classId){
        super(name);
        this.floorId=floorId;
        this.classId=classId;
    }

    public void set_inClass(boolean b) {
        this.inClassroom=b;
    }

    public int get_floor_id() {
        return this.floorId;
    }

    public int  get_class_id() {
        return this.classId ;
    }
    public boolean get_inClassroom() {return this.inClassroom;}
 }