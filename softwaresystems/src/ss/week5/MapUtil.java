package ss.week5;

import java.util.*;

public class MapUtil {

    //@ ensures \result == isOneOnOne(map);
    //@ ensures (\result || !\result);
    //@ requires map != null;
    //@ ensures \result ==(\forall K x, y; map.keyset().contains(x)
    //@ && map.keyset().contains(y) && x != y; map.get(x) !=map.get(y)
    public /*@pure*/ static <K, V> boolean isOneOnOne(Map<K, V> map) {

        for (V value : map.values()) {
            boolean found = false;

            for (K key : map.keySet()) {
                if (map.get(key) == value) {
                    if (found) {
                        return false;
                    }
                    else {
                        found = true;
                    }
                }
            }
        }

        return true;
    }

    //@ ensures (\result || !\result);
    //@ requires range != null;
    //@ requires map != null;
    public /*@pure*/ static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        for (V rangeValue : range) {
            if (!map.values().contains(rangeValue)) {
                return false;
            }

        }

        return true;

    }

    //@ requires map != null;
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> newMap = new HashMap<>();

        for(Map.Entry<K, V> entry : map.entrySet()){
            K key = entry.getKey();
            V value = entry.getValue();

            if (!newMap.containsKey(value)) {
                newMap.put(value, new HashSet<K>(Collections.singletonList(key)));
            }
            else {
                Set<K> duplicate = newMap.get(value);
                duplicate.add(key);

                newMap.put(value, duplicate);
            }
        }

        return newMap;
	}

    //@ requires map != null;
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> newMap = new HashMap<>();

        if (isOneOnOne(map) && isSurjectiveOnRange(map, new HashSet<>(map.values()))) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                newMap.put(entry.getValue(), entry.getKey());
            }
        }
        return newMap;
	}

    //@ ensures (\result || !\result);
    //@ requires f != null;
    //@ requires g 1= null;
	public /*@pure*/ static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {

        for (Map.Entry<K, V> value : f.entrySet()) {
            if(!g.containsKey(value.getValue())){
                return false;
            }
        }
        return true;
	}

    //@ ensures \typeof(\result) == \type(Map<K,W>) || \result == null;
    //@ requires f != null;
    //@ requires g != null;
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> newMap = new HashMap<>();

        if (compatible(f, g)) {
            for (Map.Entry<K, V> entry : f.entrySet()) {
                newMap.put(entry.getKey(), g.get(entry.getValue()));
            }

            return newMap;
        }

        return null;
    }

}
