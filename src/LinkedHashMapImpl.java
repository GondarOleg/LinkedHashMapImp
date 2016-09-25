import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by Oleg on 9/26/2016.
 */
public class LinkedHashMapImpl<T> implements Externalizable {

    private T key;
    private T value;


    public <T> T get(T key) {
        return null;
    }

    public <T> void put(T key, T value) {

    }

    public boolean removeEldestEntry() {
        return false;
    }

    public <T> boolean containsKey(T key) {
        return false;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(key);
        out.writeObject(value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        key = (T) in.readObject();
        value = (T) in.readObject();
    }
}
