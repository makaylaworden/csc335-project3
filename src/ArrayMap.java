/**
 * Array of keys and array of values
 * Both arrays are of type object
 */

import java.util.*;
// TODO: Doc Strings
// TODO: Iterator Remove
// TODO: All your tests

public class ArrayMap <K, V> extends AbstractMap <K, V> {
    private ArrayMapEntrySet myEntrySet;
    private int size;
    public ArrayMap(){
        myEntrySet =  new ArrayMapEntrySet();
        size = 0;
    }
    /**
     * Adds adds a key and value to the map
     * @param key the key to be added
     * @param value the value to be added
     * @return returns the old value if it is replaced,
     * otherwise returns the added value
     */
    @Override
    public V put(K key, V value){
        // TODO: Make sure it handles repeat keys
        AbstractMap.SimpleEntry<K, V> entry = new SimpleEntry<>(key, value);
        myEntrySet.addEntry(entry);
        size ++;
        return value;
    }
    /**
     * returns the number of mappings that the object contains
     * @return size, the size of the map.
     */
    @Override
    public int size() {
        return this.size;
    }
    // returns a Set of (key, value) pairs contained in an Entry obj
    @Override
    public Set<Entry<K, V>> entrySet(){
        return myEntrySet;
    }
    // Concrete set
    private class ArrayMapEntrySet extends AbstractSet<Entry<K,V>> {
        private Set<Entry<K,V>> eSet = new HashSet<>();
        private Set<K> keySet = new HashSet<>();

        public Set<Entry<K, V>> geteSet() { return eSet; }
        public Set<K> getKeySet() { return keySet; }

        private void addEntry(Entry<K, V> entry){
            eSet.add(entry);
            keySet.add(entry.getKey());
        }
        // Returns the size of the set (and of the Map)
        @Override
        public int size(){
            return eSet.size();
        }
        // Returns true if the Set contains an Entry equal to the parameter
        // If it is, validate that the key and value are actually part
        // of the Map
        @Override
        public boolean contains (Object o){
            return keySet.contains(o);
        }
        // Returns the iterator that walks over the Set of Entries in the Map
        @Override
        public Iterator<Entry<K, V>> iterator(){
            ArrayMapEntrySetIterator itty = new ArrayMapEntrySetIterator<>();
            itty.setSize(0);
            itty.setIndex(0);
            itty.setEntries(this);
            return itty;
        }

        private class ArrayMapEntrySetIterator<T> implements Iterator<T>{
            // Returns true if there are more items in the Set of
            // Entries being iterated over
            private int size;
            int index;
            private ArrayMapEntrySet entries;

            public void setSize(int newSize){ this.size = newSize; }
            public void setEntries(ArrayMapEntrySet newEntry) { this.entries = newEntry; }
            public void setIndex (int newI){ this.index = newI; }
            @Override
            public boolean hasNext(){
                return (this.entries.size() != this.size) || (this.index == this.size);
            }
            // Returns an Entry (AbstractMap.SimpleEntry<V,E>)) that
            // represents the next mapping in our Map
            @Override
            public T next(){
                this.index++;
                Object[]  entArr = entries.toArray();
                return (T) entArr[this.index];
            }
            // Removes the Entry at next
            /*
            Removes from the underlying collection the last element returned by this iterator
            (optional operation). This method can be called only once per call to next(). The
            behavior of an iterator is unspecified if the underlying collection is modified while the
            iteration is in progress in any way other than by calling this method.

            Throws:
            IllegalStateException - if the next method has not yet been called, or the
            remove method has already been called after the last call to the next method
             */
            @Override
            public void remove(){

            }

        }
    }
}
