import jsjf.DoubleOrderedList;
import jsjf.exceptions.NonComparableElementException;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleOrderedListTest {
    //add empty
    @Test
    public void add() {
       DoubleOrderedList<Integer> list = new DoubleOrderedList<Integer>();
       list.add(1);
       list.add(2);
       list.add(0);
        assertEquals(3, list.size());
        assertEquals((Integer)0, list.first());
        assertEquals((Integer)2, list.last());
    }
    //add size 1 to head

    @Test
    public void addSize1ToHead(){
        DoubleOrderedList<Integer> list = new DoubleOrderedList<Integer>();
        list.add(1);
        list.add(0);
        assertEquals(2, list.size());
        assertEquals((Integer)0, list.first());
        assertEquals((Integer)1, list.last());
    }
    //add size 1 to tail

    @Test
    public void addSize1ToTail(){
        DoubleOrderedList<Integer> list = new DoubleOrderedList<Integer>();
        list.add(0);
        list.add(1);
        assertEquals(2, list.size());
        assertEquals((Integer)0, list.first());
        assertEquals((Integer)1, list.last());
    }

    //add size 2 to head
    @Test
    public void addSize2ToHead(){
        DoubleOrderedList<Integer> list = new DoubleOrderedList<Integer>();
        list.add(0);
        list.add(55);
        list.add(1);
        assertEquals(3, list.size());
        assertEquals((Integer)0, list.first());
        assertEquals((Integer)55, list.last());
    }

    //add size 2 to tail
    @Test
    public  void addSize2ToTail(){
        DoubleOrderedList<Integer> list = new DoubleOrderedList<Integer>();
        list.add(0);
        list.add(1);
        list.add(55);
        assertEquals(3, list.size());
        assertEquals((Integer)0, list.first());
        assertEquals((Integer)55, list.last());
    }


    @Test (expected = NonComparableElementException.class)
    public void addNonComparableTest(){
        DoubleOrderedList<Integer[]> badlist = new DoubleOrderedList<Integer[]>();
        badlist.add(new Integer[]{1});
    }
}