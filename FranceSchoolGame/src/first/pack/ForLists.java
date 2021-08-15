package first.pack;

import java.util.ArrayList;
import java.util.List;

public class ForLists {

	public static void main(String[] args) {
		
		List<String> myList = generateAndDisplayList();
		
		//     1/ tell if a name is in a list
		System.out.println("Peter is in list : "+isInList(myList, "Peter"));
		System.out.println("Bil is in list : "+isInList(myList, "Bil"));
		System.out.println("Peter is in list : "+isInListFor(myList, "Peter"));
		System.out.println("Bil is in list : "+isInListFor(myList, "Bil"));
		
/*		2/ add a name if it's not already in the list
		3/ take a random name in the list
		4/ tell if some name are present at least twice.
		5 BONUS/ tell if the list is sorted*/
	}

	private static boolean isInList(List<String> myList, String name) {
		boolean isIn = false;
		//  USING a while, exiting the loop as soon as we can.
		// while we did not find the element
		// and while we are not at the end of the list.
		int index=0;
		int size=myList.size();
		while (!isIn && index<size) {
			String element = myList.get(index);
			index++;			
			isIn = element.equals(name);
		}
		return isIn;
	}
	private static boolean isInListFor(List<String> myList, String name) {
		boolean isIn = false;
		// first USING a foreach = when we know how many steps we have to loop, it's not the case here !
		for (String string : myList) {
			if (name.equals(string)) { // Attention, do not use == for Strings
				isIn=true;
			}
		}
		return isIn;
	}

	private static List<String> generateAndDisplayList() {
		List<String> names = new ArrayList<String>();
		names.add("Peter");
		names.add("Steve");  
		names.add("Barbara");
		names.add("Robert");
		names.add("Samantha");
		// foreach
		for (String name : names) {
		            System.out.println(name);
		}

		// for with a counter
		for (int i=0;i<names.size();i++) {
		            System.out.println(names.get(i));
		}
		return names;
	}

}
