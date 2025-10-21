package HashMapEmployee;
public class Employee extends Worker{
    private double salary;
    private int daysWorked;
    private int hoursWorked;

    public Employee(String firstname, String secondname, int ID) {
        super(firstname, secondname, ID);
        this.salary = Math.random() * 94 + 7.25;
        this.daysWorked = (int)(Math.random() * 6) + 1;
        this.hoursWorked = (int)(Math.random() * 9) + 1;
        super.returnPerformance();
    }

    public void changeSalary(double newSalary, Employee s) {
        s.salary = newSalary;
    }

    public double returnSalary() {
        return salary;
    }

    public void changeDaysWorked(int newDays, Employee s) {
        // You can't have an employee that either doesn't work OR works more than 7 days a week.
        if (newDays < 1 || newDays > 7) {
            return;
        }
        s.daysWorked = newDays;
    }

    public int returnDaysWorked() {
        return daysWorked;
    }

    public void changeHoursWorked(int newHours, Employee s) {
        // You can't have an employee that either doesn't work a single hour OR works more than 10 hours a day
        // because of Labor Laws.
        if (newHours < 1 || newHours > 10) {
            return;
        }
        s.hoursWorked = newHours;
    }

    public int returnHoursWorked() {
        return hoursWorked;
    }

    public int IDDifference(Employee s) {
        return this.returnID() - s.returnID();
    }

    @Override
    public String getActualPerformance() {
        if (returnPerformance() < 40) {
            return "Terrible";
        }
        else if (returnPerformance() >= 40 && returnPerformance() < 75) {
            return "Poor";
        }
        else if (returnPerformance() >= 75 && returnPerformance() < 110) {
            return "Okay";
        }
        else if (returnPerformance() >= 110 && returnPerformance() < 140) {
            return "Good";
        }
        else if (returnPerformance() >= 140 && returnPerformance() < 175) {
            return "Great";
        }
        else if (returnPerformance() >= 175 && returnPerformance() < 195) {
            return "Excellent";
        }
        else {
            return "Glory to RoboBusiness";
        }
    }

    public String toString() {
        String Title = "Employee Status: ";
        String Name = "Name: " + returnFirstName() + " " + returnSecondName();
        String ID = "ID: " + returnID();
        String Salary = "Weekly Salary: $" + String.format("%.2f",(returnSalary() * returnHoursWorked() * returnDaysWorked())) + " per week";
        String Performance = "Performance Value: " + returnPerformance() + " - " + getActualPerformance();
        return Title + "\n" + Name + "\n" + ID + "\n" + Salary + "\n" + Performance;
    }
}
