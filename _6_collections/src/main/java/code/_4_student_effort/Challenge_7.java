package code._4_student_effort;


import java.util.*;

public class Challenge_7 {
    public static void main(String args[]) {
        ArrayMap<String, Integer> myMap = new ArrayMap<>();

        myMap.put("Andrei", 5);
        myMap.put("Stefan", 10);
        myMap.put("Biculetz", 2);
        myMap.put("David", -10);

        System.out.println(myMap);
        System.out.println(myMap.get("Andrei"));
        System.out.println(myMap.get("Biculetz"));
        myMap.set("Andrei", 9);
        System.out.println(myMap);
    }
}

class ArrayMap<K, V> extends AbstractMap<K, V> {
    private ArrayList<K> keys;
    private ArrayList<V> values;

    public ArrayMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }
    class KeyValue<K, V> implements Map.Entry<K,V>{
        private K key;
        private V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldvalue;

            oldvalue = this.value;
            this.value = value;
            return oldvalue;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Map.Entry<K, V> entry : this.entrySet())
            result += "Key = " + entry.getKey() +
                    ", Value = " + entry.getValue() + "\n";
        return result;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        ArrayList<KeyValue<K, V>> array = new ArrayList<>();

        for(int i = 0; i < keys.size(); i++) {
            K key1 = keys.get(i);
            V val1 = values.get(i);
            array.add(new KeyValue<>(key1, val1));
        }
        return new HashSet<>(array);
    }

    public V put(K key, V value) {
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        }
        return value;
    }

    public V get(Object obj) {
        int index;
        K key = (K) obj;
        index = keys.indexOf(key);
        return values.get(index);
    }

    public Set<K> keySet() {
        return new HashSet<>(keys);
    }

    public Collection<V> values() {
        return values;
    }

    public void set(K key, V val) {
        if(keys.contains(key)) {
            int index = keys.indexOf(key);
            values.set(index, val);
        }
    }
}

