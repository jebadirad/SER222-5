import jsjf.*;
import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;
import jsjf.exceptions.NonComparableElementException;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DoubleListTest {

    DoubleOrderedList<Integer> list = new DoubleOrderedList<Integer>();
    @Before
    public void setUp() throws Exception {
        list.add(22);
        list.add(2);
        list.add(1);
        list.add(83);
        list.add(3);
        list.add(6);
        list.add(9);
        list.add(15);
        //list is 1 2 3 6 9 15 22 83;
        //count 8
    }

    @Test
    public void removeFirst() {
        assertEquals(8, list.size());
        assertEquals((Integer)1, list.removeFirst());
        assertEquals(7, list.size());
    }
    
    @Test(expected = EmptyCollectionException.class)
    public void removeFirstEmpty(){
        DoubleOrderedList<Integer> empty = new DoubleOrderedList<Integer>();
        empty.removeFirst();

    }
    @Test(expected = EmptyCollectionException.class)
    public void removeLastEmpty(){
        DoubleOrderedList<Integer> empty = new DoubleOrderedList<Integer>();
        empty.removeLast();
    }
    @Test
    public void removeLast() {
        assertEquals(8, list.size());
        assertEquals((Integer)83, list.removeLast());
        assertEquals(7, list.size());
    }
    @Test
    public void remove() {
        assertEquals(8, list.size());
        //somewhere in the middle
        assertEquals((Integer)6, list.remove(6));
        assertEquals(7, list.size());
        //at the front.
        assertEquals((Integer)1, list.remove(1));
        assertEquals(6, list.size());
        //at the back
        assertEquals((Integer)83, list.remove(83));
        assertEquals(5, list.size());

    }
    @Test(expected = NonComparableElementException.class)
    public void removeNonComparableTest(){
        DoubleOrderedList<Integer[]> badlist = new DoubleOrderedList<Integer[]>();
        badlist.remove(new Integer[]{1});


    }
    @Test(expected = EmptyCollectionException.class)
    public void removeEmptyCollection(){
        DoubleOrderedList<Integer> emptyList = new DoubleOrderedList<Integer>();
        emptyList.remove(1);

    }
    @Test(expected = EmptyCollectionException.class)
    public void removeAllandMoreCollection(){
        list.remove(22);
        list.remove(2);
        list.remove(1);
        list.remove(83);
        list.remove(3);
        list.remove(6);
        list.remove(9);
        list.remove(15);
        list.remove(9);


    }
    @Test(expected = ElementNotFoundException.class)
    public void removeNotFoundTest(){
        list.remove(999);
    }
    @Test
    public void first() {
        assertEquals((Integer)1, list.first());
        list.remove(1);
        assertEquals((Integer)2, list.first());
        list.removeFirst();
        assertEquals((Integer)3, list.first());
    }
    @Test(expected = EmptyCollectionException.class)
    public void firstEmptyTest(){

        DoubleOrderedList<Integer> emptyList = new DoubleOrderedList<Integer>();
        emptyList.first();
    }

    @Test
    public void last() {
        assertEquals((Integer)83, list.last());
        list.remove(83);
        assertEquals((Integer)22, list.last());
        list.removeLast();
        assertEquals((Integer)15, list.last());
    }
    @Test(expected = EmptyCollectionException.class)
    public void lastEmptyTest(){

        DoubleOrderedList<Integer> emptyList = new DoubleOrderedList<Integer>();
        emptyList.last();
    }

    @Test
    public void contains() {
         assertTrue(list.contains(3));
         assertFalse(list.contains(888));
         assertTrue(list.contains(1));
         list.add(888);
         assertTrue(list.contains(888));
         list.remove(3);
         assertFalse(list.contains(3));
    }

    @Test
    public void isEmpty() {
        assertFalse(list.isEmpty());
        DoubleOrderedList<Integer> emptyList = new DoubleOrderedList<Integer>();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(8, list.size());
        DoubleOrderedList<Integer> emptyList = new DoubleOrderedList<Integer>();
        assertEquals(0, emptyList.size());
        emptyList.add(1);
        assertEquals(1, emptyList.size());
        emptyList.removeFirst();
        assertEquals(0, emptyList.size());
        emptyList.add(2);
        emptyList.removeLast();
        assertEquals(0, emptyList.size());
        emptyList.add(3);
        emptyList.add(4);
        assertEquals(2, emptyList.size());
    }

    @Test
    public void iterator() {
        Iterator<Integer> iter = list.iterator();
        assertTrue(iter.hasNext());
        assertEquals((Integer)2, iter.next());
        assertTrue(iter.hasNext());
        assertEquals((Integer)3, iter.next());
    }
    @Test(expected = UnsupportedOperationException.class)
    public void iteratorRemove(){
        Iterator<Integer> iter = list.iterator();
        iter.remove();
    }

    @Test
    public void toStringTest() {
         //expected 1 2 3 6 9 15 22 83;
        String expected =  "1 2 3 6 9 15 22 83";
        assertEquals(expected, list.toString());
        list.removeLast();
        list.removeFirst();
        expected =  "2 3 6 9 15 22";
        assertEquals(expected, list.toString());
        list.add(1);
        expected =  "1 2 3 6 9 15 22";
        assertEquals(expected, list.toString());
        list.remove(3);
        list.add(888);
        expected = "1 2 6 9 15 22 888";
        assertEquals(expected, list.toString());
    }
    @Test
    public void toStringEmptyTest() {
        //expected 1 2 3 6 9 15 22 83;
        String expected =  "";
        DoubleOrderedList<Integer> emptyList = new DoubleOrderedList<Integer>();
        assertEquals(expected, emptyList.toString());
    }


}