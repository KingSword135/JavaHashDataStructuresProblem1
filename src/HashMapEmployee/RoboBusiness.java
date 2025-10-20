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
        if (Candidates.size() <= 10) {
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

    public boolean positionNeeded() {
        int pos = 10;
        int actual= Employees.size();
        if(pos > actual){
            return true;
        }
        return false;
    }

    public int downSizing() {
        int max = 20;
        int actual= Employees.size();
        int excess=0;
        if(max < actual){
            excess= actual-max;
        }
        return excess;
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

    public String toString() {
        for (Employee s : Candidates.values()) {

        }
        for (Employee s : Employees.values()) {
            System.out.println(s.toString());
        }
        return "";
    }

}

