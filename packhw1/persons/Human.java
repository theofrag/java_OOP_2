package packhw1.persons;

public abstract class Human{
    
    protected String name;

    Human(String name){
        this.name = name;
    }

    public String get_name(){
        return this.name;
    }

 }