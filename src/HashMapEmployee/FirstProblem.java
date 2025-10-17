package HashMapEmployee;
import java.util.HashMap;

public class FirstProblem {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Employee e = new Employee("Marisa","Kirisame",55);
        // RoboBusiness rb = new RoboBusiness();
        // HashMap<Employee, Integer> v = new HashMap<>();
        // v.put(e,1);
        // v.remove(e,1);
        System.out.println(e.toString());
        e.setPerformance(200);
        System.out.println(e.getActualPerformance());
        e.changeSalary(6.53,e);
        System.out.println(e.toString());
    }
}
