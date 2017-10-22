package practice;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void simpleMapTest()
	{
		HashMap<Integer, String> testMap = new HashMap<Integer, String>();
		testMap.put(10, "Hello");
		testMap.put(20, "wello");
		testMap.put(30, "tello");
		testMap.put(40, "gello");
		if (testMap.containsKey(20))
			System.out.println("Got it!");
		for (Map.Entry<Integer, String> kv: testMap.entrySet()) {
			System.out.println(kv.getValue() + " " + kv.getKey());
			
		}
	}
}
