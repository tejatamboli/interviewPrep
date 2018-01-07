package Collection;
import java.util.*;

public class demo {
	
	public static void main(String[] args) {
	List<String> a1 = new ArrayList<>();
    a1.add("test");
    a1.add("Mahnaz");
    a1.add("Ayan");
    System.out.println(" ArrayList Elements");
    System.out.print("\t" + a1);

    // LinkedList
    List<String> l1 = new LinkedList<>();
    l1.add("Zara");
    l1.add("Mahnaz");
    l1.add("Ayan");
    System.out.println();
    System.out.println(" LinkedList Elements");
    System.out.print("\t" + l1);

    // HashSet
    Set<String> s1 = new HashSet<>(); 
    s1.add("Zara");
    s1.add("Mahnaz");
    s1.add("Ayan");
    System.out.println();
    System.out.println(" Set Elements");
    System.out.print("\t" + s1);
	}
	
	//HashMAp is also a collection
	
	//http://www.javawebtutor.com/articles/corejava/java_arraylist_methods.php
	//This has all arraylist problems
	

}
