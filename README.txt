
### Περιγραφή Υλοποιησης, επιλογης Classes και inheritance.
javac -encoding "UTF-8" Hw1.java

Για την εκτελεση πρεπει να δωθει η εντολη java Hw1, με 5 ορισματα
Πχ: java Hw1  1 2 3 4 10
Το πρωτο, δηλωνει την χωρητικοτητα της ταξης Cclass
To δευτερο, δηλωνει το Ls, το τριτο το Lj, το τεταρτο το Lt, και το πεμπτο
τις ωρες που θα λειτουργησει το κρηριο.

##  Περιγραφή υλοποιησης των ανθρωπων.

    <class Human>:
        Αρχικα υπαρχει μια abstract κλαση η "Human". Η Human αναπαριστα έναν άνθρωπο.
        Εχει σαν μέλος ενα string που δηλωνει το όνομα του και ειναι private γιατι δεν 
        πρεπει να αλλάζει.Καθορίζεται κατα την φαση δημιουργιας του.

    <class Academic>:
        Η κλάση "Academic" ειναι υποκλάση της human. Πρακτικά κατηγοριοποιει έναν "Human"
        Κάθε "Academic" χαρακτηρίζεται απο τα στοιχεία της τάξης του , μια ένδειξη για το
        αν είναι μέσα σε αυτή και εναν ακεραιο που δηλωνει την κούραση του Academic. Επίσης ABSTRACT κλάση.

    <class Student> / class <Teacher>:
        Οι κλάσεις  "Student" και "Teacher" είναι υποκλάσεις της "Academic". 
        Πρακτικά κατηγοριοποιουν έναν "Academic" ανάλογα με το πόστο του. Δηλαδή,
        αν είναι δάσκαλος ή μαθητής.
       
        

    <class Junior>/ <class senior>:
        Οι κλάσεις  "Junior" και "Senior" είναι υποκλάσεις του "Student". 
        Πρακτικά κατηγοριοποιουν έναν "Student" ανάλογα με την ιδιότητα του. Δηλαδή,
        αν είναι senior ή junior.
        
    Επέλεξα τα Lt, Ls, Lj να ειναι μέλη των κλασεων Tacher, Senior, Junior αντιστοιχα.
    Αυτο ώστε αν αργοτερα αποφασιστει για καποιον λογο ο ρυθμος κουρασης του Student/senior/junior, 
    να οριζεται με διαφορετικο τροπο , να μην επηρεαστουν οι ρυθμοι κουρασης των υπολοιπων.



    ##  Περιγραφή υλοποιησης των χώρων.

    <class Space>:
        Αρχικά υπαρχει μια abstract κλαση η "Space". Η space αναπαριστά ενα χωρο.
        Καθε χώρος εχει καποιες ιδιότητες. Φιλοξενεί μέσα του μαθητές <Student> που μπαίνουν ΚΑΙ
        βγαίνουν απο αυτο τον χώρο. Τους μαθητές τους κρατάει μέσα σε μια λίστα.
        Συμφωνα με την παρουσα ασκηση , στα schoolyard,stairs,corridor, δεν θα κολλησει ποτε μαθητής
        σε κάποιο χώρο. 
        Παρολα αυτα,  ειναι πιο ευκολα επεκτασιμο και τροποποιησιμο με λίστα ,καθως δεν 
        χρειαζεται αλλαγή, σε περίπτωση που αποφασισουμε στα schoolyard/corridor/stairs να αλλάξουμε
        υλοποιηση καποια αλλη στιγμη.Πχ να μπαινει περιορισμενος αριθμος μαθητων.


    <class Trasplace>:
        Abstract κλάση. Εχει την έννοια ενος σταδίου. Σε αυτο μπορουν να μπαινουν μαθητες και καθηγητες
        και σε καποιες περιπτωσεις να βγαίνουν. Αυτο το σταδιο εχει κοινες μεθοδους τις:
            enter
            operate
            place
            print
        Δηλαδή, βάζει μαθητές στο κτήριο, λειτουργεί το κτηριο για καποιες ωρες, τοποθετει
        δασκαλους και εκτυπώνει μυνηματα.
        

    <class School>: 
        Ειναι υποκλάση του χώρου Trasplace.  Κάθε σχολείο έχει (has a) Yard, Stairs, Floors.
        
    <class Yard>
        Η κλάση αυτη είναι υποκλάση της κλάσης "Space". Αυτο γιατι αναπαριστα χώρο
        που μπαίνουν και βγαίνουν μαθητές.
    
    <class Stairs>
        Η κλάση αυτη είναι υποκλάση της κλάσης "Space". Αυτο γιατι αναπαριστα χώρο
        που μπαίνουν και βγαίνουν μαθητές.
    
    
    <class Corridor>    
        Η κλάση αυτη είναι υποκλάση της κλάσης "Space". Αυτο γιατι αναπαριστα χώρο
        που μπαίνουν και βγαίνουν μαθητές.
    
    <class Classroom>:
        H κλαση "classroom" ειναι και αυτη υποκλάση της Trasplace, καθώς αναπαριστά ένα χώρο που
        μπαίνουν μαθητές. Ωστοσο έχει μια μεταβλητη επιπλεον που ειναι δεικτης σε δάσκαλο
        καθώς σε κάθε τάξη μπαινει καποιος δάσκαλος.
        Αν σε καποια classroom δεν χωρανε αλλοι μαθητες, τοτε αυτοι μενουν στον διαδρομο του οροφου

    < class Floor >:
        Δεν εχει υποκλάσεις.Είναι υποκλαση του Trasplace. H κλάση floor αποτελείται απο (has a) διαδρόμο και σχολική αιθουσα.
