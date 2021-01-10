// import java.util.LinkedList;
import java.util.Random; 
import packhw1.persons.*;
import packhw1.infrastructures.*;


public class Hw1 {
    public static void main(String[] args) {
        final int MAX=18;
        int Cclass = 1; // Integer.parseInt(args[1]);
        int Lj = 2;     // Integer.parseInt(args[2]);
        int Ls = 3;      // Integer.parseInt(args[3]);
        int Lt = 5;      // Integer.parseInt(args[4]);
        // int N
        
        School school= new School(Cclass);  //Δημιουργω ενα σχολειο
        Teacher [] teachers= new Teacher[MAX];   //Δημιουργω 18 καθηγητες
        Student [] students= new Student[MAX*Cclass]; //Δημιουργω τους καταλληλους μαθητες

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

        int end=Cclass*MAX; //Aριθμος μαθητων
        int div=18;
        int temp=0;
        int i=0;
        Student s;
        Random rand = new Random();
        
    while(true){

        temp= rand.nextInt(end+1);   // επιλεγω τυχαιο αριθμο που θα μπουνε στο yar
        

        for(int k=0;k<temp;k++){
            if(end==0)             // Αν μπήκαν όλοι οι μαθητες, αυτο θα είναι 0
                break;
            
            i= rand.nextInt(end);   // αριθμος μαθητων συνολικος επιλεγω εναν μαθητη
           
                 s=students[i];
                students[i]=students[end-1];    // τον βαζω στο τελος για να μην τον ξαναπαρω
                students[end-1]=s;
                end--;
                school.enter(s);               // βαζω στο yard τον μαθητη αν χωραει
        }
        
        int times=rand.nextInt(div+1);

        for(int k=0;k<times;k++){
            if(div==0)
                break;
            i=rand.nextInt(div);
            school.place((teachers[i]));
            Teacher tempTeacher= teachers[i];
            teachers[i]=teachers[div-1];
            teachers[div-1]=tempTeacher;
            div--; 
        }
    if(end==0 && div==0)
        break;

    }


    school.operate(10);
    school.print();
    school.empty();
    }
}