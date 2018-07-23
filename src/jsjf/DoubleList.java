package jsjf;

import java.util.Iterator;
import jsjf.exceptions.*;
/**
 * A class that represents a doubly linked structure, with functionality to remove nodes.
 *
 * @author  JonDavid Ebadirad, Acuna
 * @version 1.0
 */
public class DoubleList<T> implements ListADT<T>, Iterable<T> {
      protected int count;
      protected DoubleNode<T> head;


      public  DoubleList(){
        count = 0;
        head = null;

      }
    /**
     * Removes and returns the first element from this list.
     * @throws EmptyCollectionException if the list is empty;
     * @return the first element from this list
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {

        if(null != head && count > 0){
            T removed = head.getElement();
            head = head.getNext();
            if(null != head){
                head.setPrev(null);
            }
            count --;
            return removed;
        }else{
            throw new EmptyCollectionException("Double List collection");
        }
    }

    /**
     * Removes and returns the last element from this list.
     * @throws EmptyCollectionException if the list is empty;
     * @return the last element from this list
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if(count > 0 ){
            DoubleNode<T> temp = head;
            while(null != temp.getNext()){
                temp = temp.getNext();
            }
            T removed = temp.getElement();
            DoubleNode<T> prev = temp.getPrev();
            if(null != prev){
                prev.setNext(null);
            }
            temp.setPrev(null);
            count --;
            return removed;
        }else{
            throw new EmptyCollectionException("Double List collection");
        }
    }

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     */
    @Override
    public T remove(T element) throws NonComparableElementException,
        EmptyCollectionException, ElementNotFoundException
    {
        if(!(element instanceof Comparable)){
            throw new NonComparableElementException("Double List");
        }else{
            if(count > 0){
                Comparable<T> target = (Comparable<T>)element;
                DoubleNode<T> temp = head;
                T found = null;
                while(null != temp.getNext()){
                    if(target.compareTo(temp.getElement()) == 0){
                        DoubleNode<T> before = temp.getPrev();
                        DoubleNode<T> after = temp.getNext();
                        found = temp.getElement();
                        if(null != before){
                            before.setNext(after);
                        }
                        else{
                            head = after;
                        }
                        if(null != after){
                            after.setPrev(before);
                        }
                        count --;
                        break;
                    }else{
                        temp = temp.getNext();
                    }
                }
                if(null == found){
                    //reached the end, check last
                    if(target.compareTo(temp.getElement()) == 0){
                        found = temp.getElement();
                        DoubleNode<T> before = temp.getPrev();
                        if(null != before){
                            before.setNext(null);
                        }

                        count --;
                    }else{
                        throw new ElementNotFoundException("Double List");
                    }
                }
                return found;
            }else{
                throw new EmptyCollectionException("Double List");
            }

        }
    }

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    @Override
    public T first() throws EmptyCollectionException {
        if(null != head){
            return head.getElement();
        }else{
            throw new EmptyCollectionException("Double List Collection");
        }
    }

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    @Override
    public T last() throws EmptyCollectionException {
        if(count > 0){
            DoubleNode<T> temp = head;
            while(null != temp.getNext()){
                temp = temp.getNext();
            }
            return temp.getElement();
        }else{
            throw new EmptyCollectionException("Double List Collection");
        }
    }

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        DoubleNode<T> tempHead = head;
        while(null != tempHead.getNext()){
            if(tempHead.getElement().equals(target)){
                return true;
            }else{
               tempHead = tempHead.getNext();
            }
        }
        //last chance to find it
        if(tempHead.getElement().equals(target)){
            return true;
        }
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return count;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            DoubleNode<T> current = head;
            @Override
            public boolean hasNext() {
                if (null == current.getNext()) {
                    return false;
                }else{
                    return true;
                }

            }

            @Override
            public T next() {
                current = current.getNext();
                return current.getElement();
            }
            public void remove() throws UnsupportedOperationException{
                throw new UnsupportedOperationException("not allowed to delete");
            }
        };
    }

    /**
     * returns a string representation of the Double Ordered List
     * @return a String representation.
     */
    @Override
    public String toString(){
        String output = "";
        if(size() > 0 ){
            DoubleNode<T> temp = head;
            while(null != temp.getNext()){
                output += temp.getElement() + " ";
                temp = temp.getNext();
            }
            output += temp.getElement();
        }
        
        return output;
    }

}
