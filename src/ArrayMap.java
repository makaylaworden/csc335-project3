/**
 * @Author Makayla Worden
 * Course: CSc 335 Fall 2019
 * Project: Project 3, ArrayMap
 * This program creates an ArrayMap that uses Entry objects
 * to store key/value pairs in a set.
 */

import java.util.*;
public class ArrayMap <K, V> extends AbstractMap <K, V> {
    private ArrayMapEntrySet myEntrySet;
    private int size;
    public Iterator iter;
    public ArrayMap(){
        myEntrySet =  new ArrayMapEntrySet();
        iter = myEntrySet.iterator();
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
    /**
     * Returns the entrtSet being used
     * @return myEntrySet, a Set<Entry<K, V>>
     */
    @Override
    public Set<Entry<K, V>> entrySet(){
        return myEntrySet;
    }
    /**
     * ArrayMapEntrySet is the entrySet being used to store the
     * keys and values. It is the concrete iterator of this program.
     */
    private class ArrayMapEntrySet extends AbstractSet<Entry<K,V>> {
        private Set<Entry<K,V>> eSet = new HashSet<>();
        private Set<K> keySet = new HashSet<>();
        private Set<V> valueSet = new HashSet<>();

        public Set<Entry<K, V>> geteSet() { return eSet; }
        public Set<K> getKeySet() { return keySet; }
        public Set<V> getValueSet() { return valueSet; }

        private void addEntry(Entry<K, V> entry){
            eSet.add(entry);
            keySet.add(entry.getKey());
            valueSet.add(entry.getValue());
        }
       /**
         * Returns the size of the set.
         * @return size, the size of the set (and of the Map)
         */
        @Override
        public int size(){
            return eSet.size();
        }
        /**
         * Returns true if the Set contains an Entry equal to the parameter
         * If it is, validate that the key and value are actually part
         * of the Map
         * @param o the Object being checked if the Set contains it
         * @return a boolean of whether or not the Object is in the Set
         */
        @Override
        public boolean contains (Object o){
            return keySet.contains(o);
        }
        /**
         * Returns the iterator that walks over the Set of Entries in the Map
         * @return an Iterator object
         */
        @Override
        public Iterator<Entry<K, V>> iterator(){
            ArrayMapEntrySetIterator itty = new ArrayMapEntrySetIterator<>();
            itty.setSize(0);
            itty.setIndex(0);
            itty.setEntries(this);
            return itty;
        }

        /**
         * This is the object iterator.
         * @param <T> the type being iterated over.
         */
        private class ArrayMapEntrySetIterator<T> implements Iterator<T>{
            private int size;
            private boolean beenCalled = false;
            int index;
            private ArrayMapEntrySet entries;

            public void setSize(int newSize){ this.size = newSize; }
            public void setEntries(ArrayMapEntrySet newEntry) { this.entries = newEntry; }
            public void setIndex (int newI){ this.index = newI; }

            /**
             * Returns true if there are more items in the Set of
             * Entries being iterated over
             * @return true if there's a next
             */
            @Override
            public boolean hasNext(){
                return this.index == this.size;
            }
            /**
             * Returns an Entry (AbstractMap.SimpleEntry<V,E>)) that
             * represents the next mapping in our Map
             * @return the next item in the iteration
             */
            @Override
            public T next(){
                Object[]  entArr = entries.toArray();
                Object temp = entArr[this.index];
                this.index++;
                beenCalled = true;
                return (T) entArr;
            }
            /**
             * Removes the Entry at next
             * Removes from the underlying collection the last element returned by this iterator
             *             (optional operation). This method can be called only once per call to next(). The
             *             behavior of an iterator is unspecified if the underlying collection is modified while the
             *             iteration is in progress in any way other than by calling this method.
             *
             *             Throws:
             *             IllegalStateException - if the next method has not yet been called, or the
             *             remove method has already been called after the last call to the next method
             */
            @Override
            public void remove(){
                if (beenCalled)
                    throw new IllegalStateException ("next() was not called before remove");
            }

        }
    }
}
