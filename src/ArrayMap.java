/**
 * Array of keys and array of values
 * Both arrays are of type object
 */

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
// TODO: Doc Strings
public class ArrayMap <K, V> extends AbstractMap <K, V> {
    // Adds adds a key and value to the map
    @Override
    public V put(K key, V value){
        return null;
    }
    // returns the number of mappings that the object contains
    @Override
    public int size() {
        return 0;
    }
    // returns a Set of (key, value) pairs contained in an Entry obj
    @Override
    public Set<Entry<K, V>> entrySet(){
        return null;
    }
    // Concrete set
    private class ArrayMapEntrySet extends AbstractSet<Entry<K,V>> {
        // Returns the size of the set (and of the Map)
        @Override
        public int size(){
            return 0;
        }
        // Returns true if the Set contains an Entry equal to the parameter
        // If it is, validate that the key and value are actually part
        // of the Map
        @Override
        public boolean contains (Object o){
            return false;
        }
        // Returns the iterator that walks over the Set of Entries in the Map
        @Override
        public Iterator<Entry<K, V>> iterator(){
            return null;
        }

        private class ArrayMapEntrySetIterator<T> implements Iterator<T>{
            // Returns true if there are more items in the Set of
            // Entries being iterated over
            @Override
            public boolean hasNext(){
                return false;
            }
            // Returns an Entry (AbstractMap.SimpleEntry<V,E>)) that
            // represents the next mapping in our Map
            @Override
            public T next(){
                return null;
            }
            @Override
            public void remove(){

            }

        }
    }
}
