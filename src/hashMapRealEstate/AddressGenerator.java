package hashMapRealEstate;

import java.util.ArrayList;

public class AddressGenerator extends RealEstateManager {
    
    ArrayList<String> streets = new ArrayList<>() {{
        add("Maple Street");
        add("Oak Avenue");
        add("Pine Road");
        add("Cedar Lane");
        add("Elm Drive");
        add("Birch Court");
        add("Willow Way");
        add("Spruce Circle");
        add("Magnolia Boulevard");
        add("Sycamore Trail");
    }};
    
    ArrayList<String> cities = new ArrayList<>() {{
        add("Springfield");
        add("Riverside");
        add("Oakland");
        add("Lakeside");
        add("Mountain View");
        add("Greenville");
        add("Fairview");
        add("Clinton");
        add("Madison");
        add("Georgetown");
    }};
    
    ArrayList<String> states = new ArrayList<>() {{
        add("CA");
        add("TX");
        add("FL");
        add("NY");
        add("IL");
        add("PA");
        add("OH");
        add("GA");
        add("NC");
        add("MI");
    }};

    public House createRandomProperty() {
        try {
            int streetIndex = (int) (Math.random() * streets.size());
            int cityIndex = (int) (Math.random() * cities.size());
            int stateIndex = (int) (Math.random() * states.size());
            
            String streetNum = String.valueOf((int)(Math.random() * 9999) + 1);
            String address = streetNum + " " + streets.get(streetIndex) + ", " + 
                           cities.get(cityIndex) + ", " + states.get(stateIndex);
            
            double value = (Math.random() * 980000) + 20000; // $20K - $1M
            int condition = (int)(Math.random() * 101); // 0-100 scale
            
            // Create house with random type (sale or rental)
            boolean isForSale = Math.random() > 0.5;
            House house = new House(address, value, condition, isForSale);
            
            // Adjust sale probability based on condition and value
            double adjustedProbability = (condition * 0.6) + 
                                       ((1000000 - value) / 1000000 * 40);
            house.setSaleProbability(adjustedProbability);
            
            return house;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}