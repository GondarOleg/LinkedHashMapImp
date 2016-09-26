import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LinkedHashMapImpl<K, V> implements Externalizable {


    private HashMap<K, V> hashMap;

    private List<K> keys;

    private int size;


    public LinkedHashMapImpl(int size) {
        this.size = size;
        hashMap = new HashMap<>(size + 1, 1.1f);
        keys = new LinkedList<>();
    }


    public V get(Object key) {
        return hashMap.get(key);
    }


    public V put(K key, V value) {
        if(hashMap.containsKey(key)){
            keys.remove(key);
            keys.add(key);
        }
            keys.add(key);
            hashMap.put(key, value);

        return value;
    }


    public boolean containsValue(Object value) {
        return hashMap.containsValue(value);
    }

    public boolean removeEldestEntry() {
        return keys.size() > size;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    }
}
