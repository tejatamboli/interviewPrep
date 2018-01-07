package HashMap;
import java.util.*;

/*
 * based on ingredients make list for dishes
 */

public class dishesIngredients {
	public static void main(String[] args) {
		Map<String, String[]>dishList = new HashMap<>();
		dishList.put("Pasta", new String[]{"Tomato Sauce", "Onions", "Garlic"});
		dishList.put("Chicken Curry", new String[]{"Chicken", "Curry Sauce"});
		dishList.put("Fried Rice", new String[]{"Rice", "Onions", "Nuts"});
		dishList.put("Salad", new String[]{"Spinach", "Nuts"});
		dishList.put("Sandwitch", new String[]{"Cheese", "Bread"});	
		dishList.put("Quesadilla", new String[] {"Chicken", "Cheese"});
		
		group_items(dishList);
	}
	
	public static void group_items(Map<String, String[]>dishList) {
		Map<String, Set<String>> ingList = new HashMap<>();
		for (String dish: dishList.keySet()) {
			for (String ing: dishList.get(dish)) {
				if (ingList.containsKey(ing)) {
					ingList.get(ing).add(dish);
				} else {
					Set<String> dishSet = new HashSet<>();
					dishSet.add(dish);
					ingList.put(ing, dishSet);
				}
			}
		}
		
		Iterator<Map.Entry<String, Set<String>>> it = ingList.entrySet().iterator();
		while(it.hasNext()) {	
				Map.Entry<String, Set<String>>pair = it.next();
				if (pair.getValue().size() > 1) {
					System.out.println(pair.getKey() + " : " + pair.getValue());	
				}
		}
		/*for(Set<String> dishSet: ingList.values()) {
			if (dishSet.size() > 1) {
				System.out.println(dishSet);	
			}
		}*/
	}

}
