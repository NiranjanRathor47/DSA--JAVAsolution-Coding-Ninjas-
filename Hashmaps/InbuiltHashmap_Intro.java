import java.util.HashMap;
import java.util.Set;

public class InbuiltHashmap_Intro {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap();
		// Insert
		map.put("abc", 1);
		map.put("def", 2);
		map.put("abc1", 1);
		map.put("def1", 2);
		
		System.out.println(map.size());
		
		// check presence 
		if(map.containsKey("abc")) {
			System.out.println("has abc");
		}
		if(map.containsKey("abc1")) {
			System.out.println("has abc1");
		}
		if(map.containsValue(2)) {
			System.out.println("has 2 as value");
		}
		
		// Get value 
		int v=0;
		if(map.containsKey("abc")) {
			v = map.get("abc");
		}
		System.out.println(v);
		
		// remove
		int s = map.remove("abc");
		System.out.println(s);
		
		// Iterate 
		Set<String> keys = map.keySet();
		for(String str : keys) {
			System.out.print(str+" ");
		}
	}
	
}
