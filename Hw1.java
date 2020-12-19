// import java.util.LinkedList;
import java.util.Random; 
import packhw1.persons.*;
import packhw1.infrastructures.*;


public class Hw1 {
    public static void main(String[] args) {
        final int N=18;
        int Cclass = 1; // Integer.parseInt(args[1]);
        int Lj = 2;     // Integer.parseInt(args[2]);
        int Ls = 3;      // Integer.parseInt(args[3]);
        int Lt = 5;      // Integer.parseInt(args[4]);
        
        School school= new School(Cclass);
        Teacher [] teachers= new Teacher[18];
        Student [] students= new Student[N*Cclass];

        int count=0, count2=0, count1=0;
        for(int i=0;i<Cclass;i++){                      // create students and save them to an array
    
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    students[count]=new Senior("Senior "+  String.valueOf(count1),j,k,Ls);
                    count1++;
                    count++;
    
                }
                for(int k=3;k<6;k++){
                    students[count]=new Junior("Junior "+ String.valueOf(count2),j,k,Lj);
                    count2++;
                    count++;
    
                }
                
            }
        }
        count=0;
        for(int j=0;j<3;j++){   // φτιαχνω 18 δασκαλους
            for(int k=0;k<6;k++){
                teachers[count]=new Teacher("Teacher "+ String.valueOf(count),j,k,Lt);
                count++;
            }
        }
        int end=Cclass*N;
        int div=18;
        int temp=0;
        int counter=0;
        int i=0;
        Student s;
        Random rand = new Random();
        
    while(end!=0){

        temp= rand.nextInt(Cclass*N);   // επιλεγω τυχαιο αριθμο που θα μπουνε στο yar
        

        for(int k=0;k<temp;k++){
            if(counter+Cclass*N==0)             // Αν μπήκαν όλοι οι μαθητες, αυτο θα είναι 0
                break;
            
            i= rand.nextInt(Cclass*N+counter);   // αριθμος μαθητων συνολικος επιλεγω εναν μαθητη
           
                 s=students[i];
                students[i]=students[Cclass*N-1+counter];    // τον βαζω στο τελος για να μην τον ξαναπαρω
                students[Cclass*N-1+counter]=s;
                counter--;                      // Για κάθε νέο μαθητή που βάζω, το μειώνω
                school.enter(s);               // βαζω στο yard τον μαθητη αν χωραει
                end--;
        }

        if(div==0)     // Αν εχουν μπει όλοι οι καθηγητες στην τάξη τους, πρέπει να ελένξουμε και τους μαθητές
            continue;

            int times=rand.nextInt(div);
            for(int k=0;k<=times;k++){
                i=rand.nextInt(div);
                school.place(teachers[i]);
                Teacher temporary= teachers[i];
                teachers[i]=teachers[div-1];
                teachers[div-1]=temporary;
                div--; 
            }
        
    }
    school.operate(10);
    school.print();
    school.empty();
    }
}



//  abstract class Human{
    
//     protected String name;
//     protected int fatigue=0;

//     Human(String name){
//         this.name = name;
//     }

//     String get_name(){
//         return this.name;
//     }

//  }

//  abstract class Academic extends Human{

//     protected int floorId, classId;
//     protected boolean inClassroom=false;

//     Academic(String name, int floorId, int classId){
//         super(name);
//         this.floorId=floorId;
//         this.classId=classId;
//     }

//     public void set_inClass(boolean b) {
//         this.inClassroom=b;
//     }

//     public int get_floor_id() {
//         return this.floorId;
//     }

//     public int  get_class_id() {
//         return this.classId ;
//     }
//  }

//  abstract class Student extends Academic{

//     Student(String name,int floorId,int classId){
//         super(name,floorId,classId);
//         System.out.println("A new Student has been created! ");
//     }
//     public abstract void attend(int hours);
//     public void print() {
//         System.out.println("Student's name is: "+ this.name + " and students fatigue is: "+ this.fatigue);
//     }
//  }

//  class Junior extends Student{

//     private int Lj=0;
//     Junior(String name,int floorId,int classId,int L){
//         super(name, floorId, classId);
//         this.Lj=L;
//     }
//     public void attend(int hours) {
//         for(int i=0;i<hours;i++)
//         this.fatigue = this.fatigue + this.Lj;
//     }
    

//  }

//   class Senior extends Student{

//     private int Ls=0;
//     Senior(String name,int floorId,int classId,int L){
//         super(name, floorId, classId);
//         this.Ls=L;
//     }
//     public void attend(int hours) {
//         for(int i=0;i<hours;i++)
//             this.fatigue = this.fatigue + this.Ls;
//     }
//  }

//  class Teacher extends Academic{

//     private int Lt=0;
//     Teacher(String name, int floorId, int classId, int L){
//         super(name, floorId, classId);
//         this.Lt=L;
//         System.out.println("A New Teacher has been created!");
//     }

//     public void print() {
//         System.out.println("Teacher's name is: "+ this.name + " and teacher fatigue is: "+ this.fatigue);
//     }

//     public void teach(int hours){
//         for(int i=0;i<hours;i++)
//         this.fatigue = this.fatigue + this.Lt;
//     }
//  }

//--------------------------------------------------------------------

// abstract class Space{
//     protected LinkedList <Student> students = new LinkedList <Student>();
//     public abstract void enter (Student s);
//     public abstract Student exit();

// }

// abstract class Trasplace{
//     public abstract void operate(int hours);
//     public abstract void enter(Student s);
//     public abstract void place(Teacher t);


// }

// class Classroom extends Trasplace{

//     private int Cclass;
//     private int floorId;
//     private int classId;
//     private Teacher teacher;
//     private LinkedList <Student> students =new LinkedList <Student>();

//     Classroom(int C,int floorId, int classId){
//         this.Cclass=C;
//         this.floorId=floorId;
//         this.classId = classId;
//         System.out.println("A new Classroom has been constructed");
//     }
    
//     public void enter(Student s){
//         if(this.students.size() == Cclass)
//             return;
//         this.students.add(s);
//         s.set_inClass(true);
//         System.out.println(s.get_name()+ " enters Classroom");
        
//     }

//     public void place(Teacher t){
//         if(this.teacher== null){
//             this.teacher=t;
//             t.set_inClass(true);
//         }
//     }
//     public void operate(int hours){
//         for(int i=0; i<this.students.size(); i++ ){
//             this.students.get(i).attend(hours);
//         }
//         if(this.teacher!=null)
//             this.teacher.teach(hours);
//     }

//     public void print(){
//         System.out.println("People in class "+ this.floorId + "."+ this.classId + " are: ");
//         for(int i=0;i<this.students.size();i++)
//             this.students.get(i).print();
//         if(this.teacher!=null)
//             teacher.print();
//     }

//     public Student exit(){

//         if(this.students.size()==0)
//             return null;

//        this.students.getLast().set_inClass(false);
//        System.out.println(this.students.getLast().get_name()+ " exits Classroom!");
//        return this.students.removeLast();

//     }
//     public int available_space(){
//         return this.Cclass - this.students.size();
//     }

// }



// class Corridor extends Space{

//     Corridor(){
//         System.out.println("A new Corridor has been constructed");
//     }
//     public void enter(Student s){
//         this.students.add(s);
//         System.out.println(s.get_name()+ " enter Corridor!");
//     }
    
//     public Student exit(){
//         Student temp = students.getLast();
//         System.out.println(temp.get_name()+ " exits Corridor!"); 
//         students.removeLast();
//         return temp;
//     }
// }

// class Floor extends Trasplace{
//     Classroom [] classrooms = new Classroom[6];
//     Corridor corridor= new Corridor();
//     int floorId;

//     Floor(int Cclass, int floorId){
//         for(int i=0;i<6;i++)
//             this.classrooms[i]= new Classroom(Cclass, floorId, i);
//     }
//     public void enter(Student s){
//         System.out.println(s.get_name()+ " enter Floor!");
//         this.corridor.enter(s);
//         if(this.classrooms[s.classId].available_space()==0)
//             return;
//         Student temp= this.corridor.exit();
//         this.classrooms[temp.get_class_id()].enter(s);
//     }

//     public void operate(int hours){
//         for(int i=0;i<6;i++)
//             this.classrooms[i].operate(hours);
//     }

//     public void place(Teacher t){
//         this.classrooms[t.get_class_id()].place(t);
//     }
//     public void print(){
//         System.out.print("Floor number "+this.floorId+" contains: ");
//         for(int i=0;i<6;i++)
//             this.classrooms[i].print();
//     }
//     public Student exit(){

//         for(int i=0;i<6;i++){
//             Student temp=this.classrooms[i].exit();
//             if(temp==null)
//                 continue;
//             else{
//                 System.out.println(temp.get_name()+ " starts exiting!");
//                 this.corridor.enter(temp);
//                 temp = this.corridor.exit();

//                 return temp;
//             }
//         }
//         return null;
//     }

// }

// class Stairs extends Space{

//     Stairs(){
//         System.out.println("A new Stairs has been constructed");
//     }
//     public void enter(Student s){
//         this.students.add(s);
//         System.out.println(s.get_name()+ " enter Stairs!");
//     }
    
//     public Student exit(){
        
//         Student temp = students.getLast();
//         System.out.println(temp.get_name()+ " exits Stairs!"); 
//         students.removeLast();
//         return temp;
//     }
// }

// class SchoolYard extends Space{

//     SchoolYard(){
//         System.out.println("A new SchoolYard has been constructed");
//     }
//     public void enter(Student s){
//         this.students.add(s);
//         System.out.println(s.get_name()+ " enter SchoolYard!");
//     }
    
//     public Student exit(){
        
//         Student temp = students.getLast();
//         System.out.println(temp.get_name()+ " exits SchoolYard!"); 
//         students.removeLast();
//         return temp;
//     }
// }


// class School extends Trasplace{

//     private SchoolYard schoolyard = new SchoolYard() ;
//     private Stairs stairs = new Stairs();
//     private Floor[] floors= new Floor[3];

//     School(int Cclass){
//         for(int i=0;i<3;i++)
//             floors[i]=new Floor(Cclass, i);
//         System.out.println("A new School has been constructed");
//     }

//     public void place(Teacher t){
//         this.floors[t.get_floor_id()].place(t);
//     }

//     public void operate(int hours){
//         for(int i=0;i<3;i++)
//             this.floors[i].operate(hours);
//     }

//     public void enter(Student s){
//         System.out.println(s.get_name()+ " enters School!");
//         this.schoolyard.enter(s);
//         this.stairs.enter(this.schoolyard.exit());
//         Student temp= this.stairs.exit();
//         this.floors[temp.get_floor_id()].enter(temp);
//     }

//     public void print(){
//         System.out.print("School life consist of: " );
//         for (int i=0;i<3;i++)
//             this.floors[i].print();
//     }

//     public void empty(){

//         for(int i=0;i<3;i++){
//             Student temp = this.floors[i].exit();

//             while(temp!=null){
//                 this.stairs.enter(temp);
//                 temp=this.stairs.exit();
//                 this.schoolyard.enter(temp);
//                 temp = this.schoolyard.exit();
//                 temp=this.floors[i].exit();
//             }
            
//         }
//     }






// }

