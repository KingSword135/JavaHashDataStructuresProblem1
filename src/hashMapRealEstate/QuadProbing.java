package hashMapRealEstate;

import java.util.HashMap;
import java.util.Properties;
// rewritten to extract hashtable data to show probes for collsion resolution
public class QuadProbing extends RealEstateManager {
     Property[] properties;


    public Property[] fillTable(HashMap<String, Property> map){
        properties= new Property[map.size()*2];
        for(Property p: map.values()){
        int probes= 0;
        int initialSpot= Math.abs(p.hashCode()) % properties.length;
        int spot= initialSpot;
       
        while(properties[spot]!=null && probes < properties.length ){
            probes++;
            spot= (initialSpot + probes) % properties.length;
        }
        properties[spot]=p;
    }
     return properties;
    }
   


    public int quadProbe(House h, HashMap<String, Property> map){
        String key= h.returnAddress();
        int probes= 0;
        int tableSize= properties.length;
        int initialSpot= Math.abs(key.hashCode()) % tableSize;
        int spot= initialSpot;




        while(properties[spot]!=null && probes < tableSize){
            spot= (initialSpot + probes * probes) % tableSize;
            probes++;
        }
        return probes;
           
    }




     public int linearProbe(House h, HashMap<String, Property> map){
        String key= h.returnAddress();
        int probes= 0;
        int tableSize= properties.length;
        int initialSpot= Math.abs(key.hashCode()) % tableSize;
        int spot= initialSpot;




        while(properties[spot]!=null && probes < tableSize){
            spot= (initialSpot + probes) % tableSize;
            probes++;
        }
        return probes;
    }




}

