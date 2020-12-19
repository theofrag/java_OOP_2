package packhw1.persons;

public abstract class Academic extends Human{

    protected int floorId, classId;
    protected boolean inClassroom=false;

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
 }