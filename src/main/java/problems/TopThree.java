package problems;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TopThree {

	 public static <K, V extends Comparable> Map<K, V> reverseSortByValues(Map<K, V> map)
	    {
	        Map<K, V> treeMap = new TreeMap<>(new Comparator<K>() {
	            @Override
	            public int compare(K a, K b) {
	                return ((Comparable) b).compareTo(a);
	            }
	        });
	        treeMap.putAll(map);
	        return treeMap;
	    }
	public static void main(String[] args) {
	    HashMap<String, Integer> hm = new HashMap<String, Integer>();
	    hm.put("a", 1);
	    hm.put("b", 12);
	    hm.put("c", 53);
	    hm.put("d", 2);
	    hm.put("e", 17);
	    hm.put("f", 8);
	    hm.put("g", 8);
	    
	    List<String> keys = hm.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
	    
	    //System.out.println(keys.toString());
	    
	    int limit = 3;
	    int count = 0;
	    System.out.println(reverseSortByValues(hm).toString());
	    Collection<Integer> valueList = hm.values();
	    while (count < limit) {
	    	
	    }
	}

}
