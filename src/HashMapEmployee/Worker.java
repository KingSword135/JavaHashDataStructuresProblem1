package HashMapEmployee;

public abstract class Worker {
    
    private String firstname;
    private String secondname;
    private int ID;
    private int performance;

    Worker(String name1, String name2, int ID) {
        this.firstname = name1;
        this.secondname = name2;
        this.ID = ID;
        this.performance = (int)(Math.random() * 201);
    }

    Worker(String name, String name2) {
        super();
    }

    public String returnFirstName() {
        return firstname;
    }

    public String returnSecondName() {
        return secondname;
    }

    abstract public String getActualPerformance();

    public int returnPerformance() {
        return performance;
    }

    public int returnID() {
        return ID;
    }

    public void setPerformance(int newPerformance) {
        if (newPerformance > 200 || newPerformance < 0) {
            return;
        }
        performance = newPerformance;
    }

    abstract public String toString();

}
