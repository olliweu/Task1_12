package com.company;

import java.util.*;

public class Dictionary<K, V> {

    private final Map<K, V> map = new HashMap<>();

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key){
        return map.get(key);
    }

    public Collection<V> getValueList() {
        List<V> values = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V val = entry.getValue();
            values.add(val);
        }
        return values;
    }

    public Collection<K> getKeyList(V value) {
        List<K> keys = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V val = entry.getValue();
            if (val.equals(value)) {
                keys.add(key);
            }
        }
        return keys;
    }

    public boolean deleteKeys(V value) {
        Collection<K> keysToDelete = getKeyList(value);
        if (keysToDelete.isEmpty()) {
            return false;
        }
        for (K key : keysToDelete) {
            map.remove(key);
        }
        return true;
    }

    public boolean deleteValue(K key) {
        V val = map.remove(key);
        return val != null;
    }
}
