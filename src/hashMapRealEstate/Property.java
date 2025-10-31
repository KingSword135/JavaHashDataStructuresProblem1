package hashMapRealEstate;

public abstract class Property {
    
    private String address;
    private double value;
    private int condition; // 1-100 scale
    private double saleProbability;

    Property(String address, double value, int condition) {
        this.address = address;
        this.value = value;
        this.condition = condition;
        this.saleProbability = Math.random() * 100;
    }

    public String returnAddress() {
        return address;
    }

    public double returnValue() {
        return value;
    }

    public int returnCondition() {
        return condition;
    }

    public double returnSaleProbability() {
        return saleProbability;
    }

    abstract public String getPropertyStatus();

    public void setValue(double newValue) {
        if (newValue < 0) {
            return;
        }
        value = newValue;
    }

    public void setCondition(int newCondition) {
        if (newCondition > 100 || newCondition < 0) {
            return;
        }
        condition = newCondition;
    }

    public void setSaleProbability(double newProbability) {
        if (newProbability > 100 || newProbability < 0) {
            return;
        }
        saleProbability = newProbability;
    }

    abstract public String toString();
}