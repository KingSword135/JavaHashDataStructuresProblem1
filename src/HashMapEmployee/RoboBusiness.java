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

    public boolean addRecruitList(Employee s) {
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

    //Remove employee if they are doing badly
    public boolean fireEmployee(Employee s) {
        int key = s.returnID();
        if (Employees.containsKey(key)) {
            if (s.returnPerformance() < 40) {
                Employees.remove(s,key);
                return true;
            }
            return false;
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

}

