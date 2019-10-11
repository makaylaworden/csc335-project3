import java.util.Iterator;

// TODO: Doc Strings
public class ArrayMapTestitos {
    public static void main(String[] args){
        ArrayMap<String, String> mapo = new ArrayMap<>();
        mapo.put("Hello", "World");
        mapo.put("wut", "up");
        mapo.put("hi", "boop");
        Iterator iter = mapo.iter;
        while (iter.hasNext()){
            System.out.println("Next: " + iter.next());
        }

    }
}