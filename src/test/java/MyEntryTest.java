import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyEntryTest {
    MyEntry myEntry1 = new MyEntry(5, 7);
    MyEntry myEntry2 = new MyEntry(null, -5);
    MyEntry myEntry3 = new MyEntry(0, null);
    MyEntry myEntry4 = new MyEntry(-3, 7);
    MyEntry myEntry5 = new MyEntry(999, 4);


    @Test
    void getKey() {
        myEntry1.getKey();
        myEntry2.getKey();
        myEntry3.getKey();
        myEntry4.getKey();
        myEntry5.getKey();
    }

    @Test
    void getValue() {
        myEntry1.getValue();
        myEntry2.getValue();
        myEntry3.getValue();
        myEntry4.getValue();
        myEntry5.getValue();
    }

    @Test
    void setKey() {
        myEntry5.setKey(null);
        myEntry5.setKey(12);
        myEntry5.setKey(-35);
    }

    @Test
    void setValue() {
        myEntry5.setValue(null);
        myEntry5.setValue(567);
        myEntry5.setValue(-67);
    }

    @Test
    void getNext() {
        myEntry1.getNext();
        myEntry2.getNext();
        myEntry3.getNext();
        myEntry4.getNext();
        myEntry5.getNext();
    }

    @Test
    void setNext() {
        myEntry1.setNext(myEntry5);
        myEntry2.setNext(myEntry4);
        myEntry3.setNext(myEntry3);
        myEntry4.setNext(myEntry2);
        myEntry5.setNext(myEntry1);
    }

}