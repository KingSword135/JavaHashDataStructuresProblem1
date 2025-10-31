package hashMapRealEstate;

public class House extends Property {
    private boolean forSale;
    private boolean isLeased;

    public House(String address, double value, int condition, boolean forSale) {
        super(address, value, condition);
        this.forSale = forSale;
        this.isLeased = !forSale; // If not for sale, assume it's for lease
    }

    public boolean isForSale() {
        return forSale;
    }

    public boolean isLeased() {
        return isLeased;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
        this.isLeased = !forSale;
    }

    public void setLeased(boolean leased) {
        this.isLeased = leased;
        this.forSale = !leased;
    }

    @Override
    public String getPropertyStatus() {
        if (forSale) {
            if (returnSaleProbability() > 75) {
                return "High Demand - For Sale";
            } else if (returnSaleProbability() > 50) {
                return "Moderate Demand - For Sale";
            } else if (returnSaleProbability() > 25) {
                return "Low Demand - For Sale";
            } else {
                return "Very Low Demand - For Sale";
            }
        } else {
            if (returnSaleProbability() > 75) {
                return "High Demand - For Lease";
            } else if (returnSaleProbability() > 50) {
                return "Moderate Demand - For Lease";
            } else if (returnSaleProbability() > 25) {
                return "Low Demand - For Lease";
            } else {
                return "Very Low Demand - For Lease";
            }
        }
    }

    @Override
    public String toString() {
        String status = getPropertyStatus();
        String address = "Address: " + returnAddress();
        String value = "Value: $" + String.format("%,.2f", returnValue());
        String condition = "Condition: " + returnCondition() + "/100";
        String saleProb = "Sale/Lease Probability: " + String.format("%.1f", returnSaleProbability()) + "%";
        String type = "Type: " + (forSale ? "For Sale" : "For Lease");
        
        return status + "\n" + address + "\n" + value + "\n" + condition + "\n" + 
               saleProb + "\n" + type;
    }
}