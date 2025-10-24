package HashMapEmployee;

import java.util.ArrayList;
public class NameFiller extends RoboBusiness{
	
	ArrayList<String> first= new ArrayList<>() {{
		add("Max");
		add("Steve");
		add("Jason");
		add("Mike");
		add("Sam");
		add("Susan");
		add("Lara");
		add("Betty");
		add("Alice");
		add("Anige");
		add("Jessie");
		add("Riley");
		add("Jackson");
		add("Robert");
	}};
	
	ArrayList<String> last= new ArrayList<>() {{
		add("White");
	    add("Bebecki");
	    add("Abdul");
	    add("Henderson");
	    add("Mclean");
	    add("Goodman");
	    add("Abbot");
	    add("Cruz");
		add("Clark");
	    add("Johnson");
	    add("Smith");
	    add("Rivera");
	    add("Kim");
	    add("Lee");
		}};
	
	public Employee createRandomWorker() { // creates a randomly generated ID and names to prevent tedious creation when testing can be expanded on to prevent duplicate names

		try {
			int f = (int) (Math.random()*13);
			int l = (int) (Math.random()*13);
			int ID = (int) (Math.random()*10000);
			String firstName= first.get(f);
			String lastName= last.get(l);
			//System.out.println("Your Employee is " + firstName + " " + lastName + " Their ID is:" + ID); //test code
			Employee e= new Employee(firstName, lastName, ID);
			int daysworked= e.returnDaysWorked();
			int hours= e.returnHoursWorked();
			int realPerform= ((hours*daysworked)*3) -10;
			e.setPerformance(realPerform);
			//above utilizes hours and days to generate performace int
			//System.out.println(e.toString());
			return e;
		}

		catch (Exception e) {
			System.err.println(e);
			return null;
		}
		
	}
	
	  //  public static void main(String[] args) {  //test code
	   //    NameFiller nf= new NameFiller();
	   //    nf.createRandomWorker();
	  //  }
}
