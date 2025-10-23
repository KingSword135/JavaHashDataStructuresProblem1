package HashMapEmployee;

import java.util.HashMap;

public class RoboBusiness {

    protected HashMap<Integer, Employee> Employees = new HashMap<>();
    protected HashMap<Integer, Employee> Candidates = new HashMap<>();
    //Manager
    RoboBusiness() {

    }

    public boolean addEmployeeList(Employee s) {
        int key = s.returnID();
        if (Candidates.containsKey(key) && !Employees.containsKey(key)) {
            Employees.put(key,s);
            Candidates.remove(key);
            return true;
        }
        return false;
    }

    public boolean addCandidatesList(Employee s) {
        // We want the 
        if (Candidates.size() <= Employees.size() / 2) {
            int key = s.returnID();
            if (!Candidates.containsKey(key)) {
                Candidates.put(key, s);
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public boolean hireCandidate(Employee s) {
        //Candidates need to have a higher performance than the workers
        //as performance very likely will drop over time.
        int key = s.returnID();
        if (s.returnPerformance() < 50) {
            Candidates.remove(key,s);
            return false;
        }
        // A candidate needs at least 50 points to have a chance of getting hired.
        else if (s.returnPerformance() >= 50 && s.returnPerformance() < 75) {
            int randcoin = (int)(Math.random() * 2);
            if (randcoin == 0 ) {
                Employees.put(key, s);
                Candidates.remove(key,s);
                return true;
            }
            else {
                Candidates.remove(key,s);
                return false;
            }
        }
        //Chances are 3/4 instead of 1/2 of getting hired if they are doing at least okay
        else if (s.returnPerformance() >= 75 && s.returnPerformance() < 100) {
            int randcoin = (int)(Math.random() * 4);
            if (randcoin >= 0 && randcoin < 3) {
                Employees.put(key, s);
                Candidates.remove(key,s);
                return true;
            }
            else {
                Candidates.remove(key,s);
                return false;
            }
        }
        else {
            Employees.put(key, s);
            Candidates.remove(key,s);
            return true;
        }

    }

    //Remove employee if they are doing badly
    public boolean fireEmployee(Employee s) {
        int key = s.returnID();
        if (Employees.containsKey(key)) {
            if (s.returnPerformance() < 40) {
                Employees.remove(key,s);
                return true;
            }
            // Makes it a chance if the employee isn't doing a good job but exceptions exist.
            // Glory to RoboBusiness, traitors and slackers will be removed
            else if (s.returnPerformance() >= 40 && s.returnPerformance() < 65) {
                int chance = (int)(Math.random() * 2);
                if (chance == 0) {
                    Employees.remove(key,s);
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return false;
    }

     public void fireEmployee2(Employee s) { //functionailty of fireemp1 built into other methods called in run biz
        int key = s.returnID();
        if (Employees.containsKey(key)) {
                Employees.remove(key,s);
            }
        }

    public void hireCandidate2(Employee s) {
        int key = s.returnID();
        if(Employees.containsKey(key)){
            int newkey= (int) (Math.random() * 10000);
            while(Employees.containsKey(newkey)){
                 newkey= (int)(Math.random() * 10000);
            }
            Employees.put(newkey, s);
        }
        else{
            Employees.put(key, s); 
        }
        Candidates.remove(key, s);
    }

    public int getNumEmployees() {
        return Employees.size();
    }

    public int getNumCandidates() {
        return Candidates.size();
    }

    public void printRoboBusiness() {
        System.out.println("RRR ");
        System.out.println("R R  ");
        System.out.println("RRR  ");
        System.out.println("R00R0");
        System.out.println("R000R");

    }

    public void initDatabase(int x){
        NameFiller nf= new NameFiller();
        for (int i=0; i < x; i++){
            Employee e= nf.createRandomWorker();//fills our starting database with emps
            int key = e.returnID();
            Employees.put(key, e);

        }
        for (int j=0; j < x/2; j++){//initalize candidates to be half the size of emps
            Employee e= nf.createRandomWorker();
            int key = e.returnID();
            Candidates.put(key, e);
        }

    }

    public Employee worstEmployee(){//used for fire employee
        Double maxworst=100000.0;
        Employee dummy= new Employee("dummy", "dummy",0000);

        for (Employee e: Employees.values() ){
            if(e.returnPerformance() - e.returnSalary() < maxworst){
                maxworst= e.returnPerformance() - e.returnSalary();
                dummy= e;
            }
        }
            return dummy;
            
    }

    public Employee bestCandidate(){
        Double best=-1000000.0;
        Employee dummy= null;

        for (Employee e: Candidates.values() ){
            if(e.returnPerformance() - e.returnSalary() > best){
                best= e.returnPerformance() - e.returnSalary();
                dummy= e;
            }
        }
            return dummy;
            
    }

    public Employee bestEmployee(){//used once demo is complete to show off employee to string 
        Double best=-1000000.0;
        Employee dummy= null;

        for (Employee e: Employees.values() ){
            if(e.returnPerformance() - e.returnSalary() > best){
                best= e.returnPerformance() - e.returnSalary();
                dummy= e;
            }
        }
            return dummy;
            
    }


    public String toString() {
        System.out.println("Candidates: ");
        for (Employee s : Candidates.values()) {
            System.out.println(s.toString());
            System.out.println("=====================");
        }

        for (Employee s : Employees.values()) {
            System.out.println(s.toString());
            System.out.println("=====================");
        }
        return "";
    }

}


