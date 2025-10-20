package HashMapEmployee;
public class RunBusiness extends RoboBusiness {
    public static void main(String[] args) {
        RunBusiness rs= new RunBusiness();
        rs.run();
       
}
    public void run(){// attempts to simulate database until all candidates are used
        this.initDatabase(10);
        Boolean running = true;
        int interveiws=0;
        System.out.println(Candidates.size());
        System.out.println(Employees.size());
        while (running == true) {
            if (Candidates.size()==0){
                System.out.println("Hiring Season is Over All Available Candidates Aquired After " + interveiws + " Rounds of Interveiws");
                running=false;
                break;
            }
            System.out.println("The employee fired is: " + worstEmployee().returnFirstName() + " " + worstEmployee().returnSecondName() + " ID: " + worstEmployee().returnID());
            worstEmployee().toString();
            Employee worst= worstEmployee();
            fireEmployee2(worst);
            Employee best = bestCandidate();
            hireCandidate2(best);
            System.out.println("The employee hired is: " + best.returnFirstName() + " " + best.returnSecondName() + " ID: " + best.returnID() );
            interveiws+=1;
        }
    }
}
