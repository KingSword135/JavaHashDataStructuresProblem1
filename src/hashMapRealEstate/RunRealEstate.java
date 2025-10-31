package hashMapRealEstate;

public class RunRealEstate extends RealEstateManager {
    public static void main(String[] args) {
        RunRealEstate rs = new RunRealEstate();
        rs.runSimulation();
    }
    
    public void runSimulation() {
        // Initialize with 20 properties
        this.initDatabase(20);
        
        System.out.println("=== REAL ESTATE MANAGEMENT SIMULATION ===");
        System.out.println("Initial active listings: " + getActiveListingsCount());
        System.out.println("Initial sold properties: " + getSoldPropertiesCount());
        System.out.println();
        
        // Run 10 simulation cycles
        for (int cycle = 1; cycle <= 10; cycle++) {
            System.out.println("=== SIMULATION CYCLE " + cycle + " ===");
            
            // Simulate market changes
            simulateMarketChanges();
            
            // Try to sell some properties based on probability
            int propertiesSold = 0;
            for (Property property : activeListings.values()) {
                if (Math.random() * 100 < property.returnSaleProbability()) {
                    removeListing(property.returnAddress());
                    propertiesSold++;
                }
            }
            
            // Add new listings to replace sold ones
            AddressGenerator ag = new AddressGenerator();
            for (int i = 0; i < propertiesSold; i++) {
                House newHouse = ag.createRandomProperty();
                addListing(newHouse);
            }
            
            // Display cycle results
            System.out.println("Properties sold this cycle: " + propertiesSold);
            System.out.println("New properties listed: " + propertiesSold);
            System.out.println("Active listings: " + getActiveListingsCount());
            System.out.println("Total sold properties: " + getSoldPropertiesCount());
            
            // Show best and worst listings
            Property best = getBestListing();
            Property worst = getWorstListing();
            
            if (best != null) {
                System.out.println("\nBEST LISTING (Highest Score):");
                System.out.println(best.toString());
            }
            
            if (worst != null) {
                System.out.println("\nWORST LISTING (Lowest Probability):");
                System.out.println(worst.toString());
            }
            
            System.out.println("\n" + "=".repeat(50) + "\n");
        }
        
        // Final summary
        System.out.println("=== FINAL SUMMARY ===");
        System.out.println("Total active listings: " + getActiveListingsCount());
        System.out.println("Total properties sold: " + getSoldPropertiesCount());
        
        Property overallBest = getBestListing();
        if (overallBest != null) {
            System.out.println("\nOVERALL BEST LISTING:");
            System.out.println(overallBest.toString());
        }
    }
}