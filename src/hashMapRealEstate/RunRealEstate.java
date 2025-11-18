package hashMapRealEstate;

import java.util.ArrayList;
import java.util.Scanner;

public class RunRealEstate extends RealEstateManager {
    public static void main(String[] args) {
        RunRealEstate rs = new RunRealEstate();
        rs.runSimulation();
    }
    
    public void runSimulation() {

        //Loop that will run the simulation, until the user wants to quit.

        Boolean running = true;

        while (running) {

            //Scanner doesn't close but just ignore that - it closes at the end, we need to keep it running until the program ends
            Scanner s = new Scanner(System.in);
            System.out.print("How big do you want your database to be? Enter a size: ");
            int size = s.nextInt();
            this.initDatabase(size);

            System.out.println("\n=== REAL ESTATE MANAGEMENT SIMULATION ===");
            System.out.println("Initial active listings: " + getActiveListingsCount());
            System.out.println("Initial sold properties: " + getSoldPropertiesCount() + "\n");
            
            System.out.print("How many simulation cycles do you want to run? Enter a number: ");
            // Run inputted simulation cycles
            int max = s.nextInt();
            for (int cycle = 1; cycle <= max; ++cycle) {
                System.out.println("=== SIMULATION CYCLE " + cycle + " ===");
            
                // Simulate market changes
                simulateMarketChanges();
            
                // Try to sell some properties based on probability
                int propertiesSold = 0;
                ArrayList<String> soldAddresses = new ArrayList<>();
                for (Property property : activeListings.values()) {
                    if (Math.random() * 100 < property.returnSaleProbability()) {
                        soldAddresses.add(property.returnAddress());
                    }
                }
                for (String address : soldAddresses) {
                    removeListing(address);
                    propertiesSold++;
                }//edit to fix concurency issue 
            
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

            //test quad probing vs linear probing
            AddressGenerator ag = new AddressGenerator();
            System.out.println(addListing2(ag.createRandomProperty()));

            System.out.println("This listing market is done. Do you want to continue or not?");
            System.out.println("1. Continue\n2. End");
            int choice = s.nextInt();
            if (choice == 1) {
                continue;
            }
            else if (choice == 2) {
                s.close();
                break;
            }
            else {
                while ((choice < 1) || (choice > 2)) {
                    System.out.println("You have not accepted a valid input. Try again. ");
                    choice = s.nextInt();
                }
                if (choice == 1) {
                    continue;
                }
                else if (choice == 2) {
                    s.close();
                    break;
                }
            }
        }
    }
}
