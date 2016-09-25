import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.Map;

public class LinkedHashMapImpl<K, V> extends HashMap<K, V> implements Map<K, V>, Externalizable {

    private K key;
    private V value;

    @Override
    public V get(Object key) {
        return super.get(key);
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return super.remove(key, value);
    }

    @Override
    public boolean containsValue(Object value) {
        return super.containsValue(value);
    }

    public boolean removeEldestEntry() {
        //TODO implemet method
        return false;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(key);
        out.writeObject(value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        key = (K) in.readObject();
        value = (V) in.readObject();
    }
}
