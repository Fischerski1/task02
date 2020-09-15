import java.util.Objects;

/**
 * MyEntry implementation.
 */

public class MyEntry {
    private Object key;
    private Object value;
    private MyEntry next;

    public MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public MyEntry getNext() {
        return next;
    }

    public void setNext(MyEntry next) {
        this.next = next;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object setValue(Object newValue) {
        Object oldValue = this.value;
        this.value = newValue;
        return oldValue;
    }

    /**
     * Returns entry hashcode.
     * @return int value - entry hashcode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (key == null ? 0 : key.hashCode());
        // result = prime * result + (value == null ? 0 : value.hashCode());
        return result;
    }

    /**
     * Checks if MyEntry objects are equal.
     * @return true if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyEntry myEntry = (MyEntry) obj;
        return Objects.equals(getKey(), myEntry.getKey()) &&
                Objects.equals(getValue(), myEntry.getValue());
    }

    @Override
    public String toString() {
        return "MyEntry{" +
                "K=" + key +
                ",V=" + value +
                ",N=" + next +
                "} ";
    }
}
