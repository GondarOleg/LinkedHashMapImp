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
        if(removeEldestEntry()){
            hashMap.remove(keys.get(keys.size()-1));
            keys.remove(keys.size()-1);
            keys.add(key);
            hashMap.put(key, value);
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
        out.writeObject(hashMap);
        out.writeObject(keys);
        out.write(size);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        hashMap = (HashMap<K, V>) in.readObject();
        keys = (List<K>) in.readObject();
        size = in.read();
    }
}
