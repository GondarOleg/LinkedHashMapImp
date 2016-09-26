import java.io.*;

/**
 * Created by Oleg on 9/26/2016.
 */
public class Run {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LinkedHashMapImpl<Integer, String> linkedHashMap1 = new LinkedHashMapImpl<>(11);

        linkedHashMap1.put(1, "first");
        System.out.println(linkedHashMap1.get(1));

        linkedHashMap1.writeExternal(new ObjectOutputStream(new FileOutputStream("test")));

        LinkedHashMapImpl<Integer, String> linkedHashMap2 = new LinkedHashMapImpl<>(11);
        linkedHashMap2.readExternal(new ObjectInputStream(new FileInputStream("test")));
        System.out.println(linkedHashMap2.get(1));
    }
}
