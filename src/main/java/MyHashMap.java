import java.util.Arrays;

/**
 * Hashmap implementation with the usage of arrays.
 */

public class MyHashMap {
    private final int DEFAULT_CAPACITY = 16;
    private MyEntry[] table = new MyEntry[DEFAULT_CAPACITY];
    private int threshold = (int) (table.length * 0.75);
    private int size;

    /**
     * Returns size of map.
     * @return int value; size of map
     */
    public int getSize() {
        return size;
    }

    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private MyEntry nodeThrough(MyEntry myEntry, Object key) {
        while (myEntry != null) {
            if (myEntry.getKey() != null) {
                if (myEntry.getKey().equals(key) || myEntry.getKey() == key) {
                    return myEntry;
                }
            } else {
                if (key == null)
                    return myEntry;
            }
            myEntry = myEntry.getNext();
        }
        return null;
    }

    private MyEntry addEntry(Object key, Object value) {
        return new MyEntry(key, value);
    }

    private void putForNullKey(Object value) {
        if (table[0] != null) {
            MyEntry myEntry = nodeThrough(table[0], null);
            if (myEntry != null) {
                myEntry.setValue(value);
            } else {
                MyEntry newMyEntry = addEntry(null, value);
                newMyEntry.setNext(table[0]);
                table[0] = newMyEntry;
                size++;
            }
        }
        else {
            table[0] = addEntry(null, value);
            size++;
        }
    }

    /**
     * Adds an element(entry) into a hashmap.
     * If hashmap already contains an element with the specified key, an element will be replaced with the new one.
     * @param key unique entry identifier
     * @param value value matching a specific key
     */
    public void put(Object key, Object value) {
        resize();
        if (key != null) {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, table.length - 1);

            if (table[index] != null) {
                MyEntry myEntry = nodeThrough(table[index], key);
                if (myEntry != null) {
                    myEntry.setValue(value);
                } else {
                    MyEntry newMyEntry = addEntry(key, value);
                    newMyEntry.setNext(table[index]);
                    table[index] = newMyEntry;
                    size++;
                }
            } else {
                table[index] = addEntry(key, value);
                size++;
            }
        } else {
            putForNullKey(value);
        }
    }

    /**
     * Finds an element(entry) with the specific key.
     * @param key unique entry identifier
     * @return entry matching the key; null if no entry is matching the key
     */
    public MyEntry get(Object key) {
        MyEntry myEntry;
        if (key == null) {
            myEntry = nodeThrough(table[0], key);
        } else {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, table.length - 1);
            myEntry = nodeThrough(table[index], key);
        }
        if (myEntry != null) {
            return myEntry;
        }
        return null;
    }

    /**
     * Returns true if hashmap has an entry with the specified key, false otherwise.
     * @param key unique entry identifier
     * @return true if hashmap has an entry with the specified key, false otherwise
     */
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    private void transfer(MyEntry entry, MyEntry[] newTable) {
        while (entry != null) {
            int index = 0;
            if (entry.getKey() != null) {
                int hash = hash(entry.getKey().hashCode());
                index = indexFor(hash, table.length - 1);
            }
            if (newTable[index] != null) {
                MyEntry newEntry = addEntry(entry.getKey(), entry.getValue());
                newEntry.setNext(newTable[index]);
                newTable[index] = newEntry;
            } else {
                newTable[index] = addEntry(entry.getKey(), entry.getValue());
            }
            entry = entry.getNext();
        }
        table = newTable;
    }

    private void resize() {
        if (size >= threshold) {
            MyEntry[] newTable = new MyEntry[table.length * 2];
            for (MyEntry entry : table) {
                if (entry != null) {
                    transfer(entry, newTable);
                }
            }
        }
    }

    /**
     * Removes an entry with a specific key.
     * @param key unique entry identifier
     * @return true if entry was removed, false otherwise
     */
    public boolean remove(Object key) {
        MyEntry result = removeMyEntry(key);
        return result != null ? true : false;
    }

    private MyEntry removeMyEntry(Object key) {
        int index = 0;
        if (key != null) {
            int hash = hash(key.hashCode());
            index = indexFor(hash, table.length - 1);
        }
        MyEntry myEntry = table[index];
        MyEntry result = null;

        if (myEntry != null) {
            if (key != null) {
                if (myEntry.getKey().equals(key) || myEntry.getKey() == key) {
                    result = myEntry;
                    table[index] = myEntry.getNext();
                    size--;
                    return result;
                }
                while (myEntry.getNext() != null) {
                    if (myEntry.getNext().getKey().equals(key) || myEntry.getNext().getKey() == key) {
                        break;
                    }
                    myEntry = myEntry.getNext();
                }
                if (myEntry.getNext() != null) {
                    MyEntry myNewEntry = myEntry.getNext().getNext();
                    myEntry.setNext(myNewEntry);
                    result = myEntry;
                    size--;
                    return result;
                }
            } else {
                if (myEntry.getKey() == null) {
                    table[index] = myEntry.getNext();
                    size--;
                    return myEntry;
                } else {
                    while (myEntry.getNext() != null) {
                        if (myEntry.getNext().getKey() == null) {
                            break;
                        }
                        myEntry = myEntry.getNext();
                    }
                    if (myEntry.getNext() != null) {
                        MyEntry myNewEntry = myEntry.getNext().getNext();
                        myEntry.setNext(myNewEntry);
                        result = myEntry;
                        size--;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(table) + ", size=" + size + ", table length=" + table.length;
    }

}
