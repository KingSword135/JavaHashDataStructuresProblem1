package hashMapRealEstate;

import java.util.HashMap;

public class QuadProbing extends RealEstateManager {

//currently works but shows no diffrence will alter methods to use hashtable in future updates
    public int quadProbe(House h, HashMap<String, Property> map){

        String key = h.returnAddress();
        int probes = 0;
        int tableSize = map.size() *2;
        int initialSpot = Math.abs(key.hashCode()) % tableSize;
        int spot = initialSpot;

        while(probes < tableSize){

            //Uses the quadratic probing to get a spot
            spot = (initialSpot + probes * probes) % tableSize;
            boolean doesCollide = false;

            for(String keys: map.keySet()) {

                //Checks if the quadratic spot is equal to the hash
                int hashs = Math.abs(keys.hashCode()) % tableSize;
                if(spot == hashs){
                    doesCollide = true;
                    break;
                }

            }

            if (doesCollide == false) {
                return probes+1;
            }
            ++probes;
        }
        return probes;
            
    }


     public int linearProbe(House h, HashMap<String, Property> map){

        String key = h.returnAddress();
        int probes = 0;
        int tableSize = map.size() * 2;
        int initialSpot = Math.abs(key.hashCode()) % tableSize;
        int spot = initialSpot;

        while(probes < tableSize){
            spot = (initialSpot + probes) % tableSize;

            boolean doesCollide=false;
            for(String keys : map.keySet()){
                int hashs =  Math.abs(keys.hashCode()) % tableSize;
                if(spot == hashs){
                    doesCollide = true;
                    break;
                }
            }
            if(doesCollide == false){
                return probes+1;
            }
            probes++;
        }
        return probes;
            
    }


}

