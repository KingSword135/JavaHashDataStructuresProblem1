package hashMapRealEstate;

import java.util.HashMap;

public class RealEstateManager {

    protected HashMap<String, Property> activeListings = new HashMap<>();
    protected HashMap<String, Property> soldProperties = new HashMap<>();
    
    RealEstateManager() {
    }

    public boolean addListing(Property property) {
        String key = property.returnAddress();
        if (!activeListings.containsKey(key)) {
            activeListings.put(key, property);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeListing(String address) {
        if (activeListings.containsKey(address)) {
            Property removed = activeListings.remove(address);
            soldProperties.put(address, removed);
            return true;
        }
        return false;
    }

    public boolean updatePropertyCondition(String address, int newCondition) {
        if (activeListings.containsKey(address)) {
            Property property = activeListings.get(address);
            property.setCondition(newCondition);
            
            // Update value based on condition change
            double valueChange = (newCondition - property.returnCondition()) * 1000;
            property.setValue(property.returnValue() + valueChange);
            
            // Update sale probability based on condition
            double newProbability = (newCondition * 0.7) + 
                                  ((1000000 - property.returnValue()) / 1000000 * 30);
            property.setSaleProbability(newProbability);
            
            return true;
        }
        return false;
    }

    public void simulateMarketChanges() {
        for (Property property : activeListings.values()) {
            // Random condition changes over time
            int conditionChange = (int)(Math.random() * 11) - 5; // -5 to +5
            int newCondition = Math.max(0, Math.min(100, 
                property.returnCondition() + conditionChange));
            
            property.setCondition(newCondition);
            
            // Market value fluctuations
            double valueChange = (Math.random() * 0.1) - 0.05; // -5% to +5%
            double newValue = property.returnValue() * (1 + valueChange);
            property.setValue(newValue);
            
            // Update sale probability based on market conditions
            double marketFactor = Math.random() * 20 - 10; // -10 to +10
            double newProbability = Math.max(0, Math.min(100,
                property.returnSaleProbability() + marketFactor));
            property.setSaleProbability(newProbability);
        }
    }

    public Property getBestListing() {
        double bestScore = -1;
        Property bestProperty = null;

        for (Property property : activeListings.values()) {
            double score = property.returnSaleProbability() * 
                         (property.returnCondition() / 100.0) *
                         (1 / (property.returnValue() / 1000000));
            if (score > bestScore) {
                bestScore = score;
                bestProperty = property;
            }
        }
        return bestProperty;
    }

    public Property getWorstListing() {
        double worstScore = Double.MAX_VALUE;
        Property worstProperty = null;

        for (Property property : activeListings.values()) {
            double score = property.returnSaleProbability();
            if (score < worstScore) {
                worstScore = score;
                worstProperty = property;
            }
        }
        return worstProperty;
    }

    public int getActiveListingsCount() {
        return activeListings.size();
    }

    public int getSoldPropertiesCount() {
        return soldProperties.size();
    }

    public void initDatabase(int numProperties) {
        AddressGenerator ag = new AddressGenerator();
        for (int i = 0; i < numProperties; i++) {
            House house = ag.createRandomProperty();
            addListing(house);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ACTIVE LISTINGS (").append(activeListings.size()).append(" properties):\n");
        sb.append("================================================================================\n");
        
        for (Property property : activeListings.values()) {
            sb.append(property.toString()).append("\n");
            sb.append("--------------------------------------------------------------------------------\n");
        }
        
        sb.append("\nSOLD PROPERTIES (").append(soldProperties.size()).append(" properties):\n");
        sb.append("================================================================================\n");
        
        for (Property property : soldProperties.values()) {
            sb.append(property.toString()).append("\n");
            sb.append("--------------------------------------------------------------------------------\n");
        }
        
        return sb.toString();
    }
}