import org.junit.Test;
import jsjf.*;
import static org.junit.Assert.*;

public class DoubleNodeTest {
    DoubleNode<Integer> node = new DoubleNode<Integer>();

    @Test
    public void getPrev() {
        assertEquals(null, node.getPrev());
        DoubleNode<Integer> node1 = new DoubleNode<Integer>(1);
        node.setPrev(node1);
        assertEquals(node1, node.getPrev());
        assertEquals((Integer)1, node.getPrev().getElement());
    }

    @Test
    public void getNext() {
        assertEquals(null, node.getNext());
        DoubleNode<Integer> node1 = new DoubleNode<Integer>(1);
        node.setNext(node1);
        assertEquals(node1, node.getNext());
        assertEquals((Integer)1, node.getNext().getElement());
    }

    @Test
    public void setPrev() {
        assertEquals(null, node.getPrev());
        DoubleNode<Integer> node1 = new DoubleNode<Integer>(1);
        node.setPrev(node1);
        assertEquals(node1, node.getPrev());
    }

    @Test
    public void setNext() {
        assertEquals(null, node.getNext());
        DoubleNode<Integer> node1 = new DoubleNode<Integer>(1);
        node.setNext(node1);
        assertEquals(node1, node.getNext());
    }

    @Test
    public void getElement() {
        assertEquals(null, node.getElement());
        node.setElement(1);
        assertEquals((Integer)1, node.getElement());
        DoubleNode<Integer> node1 = new DoubleNode<Integer>(5);
        assertEquals((Integer)5, node1.getElement());

    }

    @Test
    public void setElement() {
        assertEquals(null, node.getElement());
        node.setElement(1);
        assertEquals((Integer) 1, node.getElement());
    }
}