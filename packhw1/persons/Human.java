package packhw1.persons;

public abstract class Human{
    
    protected String name;
    // protected int fatigue=0;

    Human(String name){
        this.name = name;
    }

    public String get_name(){
        return this.name;
    }

 }