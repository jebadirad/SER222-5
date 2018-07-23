package jsjf;

import jsjf.exceptions.*;

import java.util.Iterator;

/**
 *  A class that extends the functionality from jsjf.DoubleList by adding a method to add
 * new elements.
 *
 * @author JonDavid Ebadirad, Acuna
 * @version 1.0
 */
public class DoubleOrderedList<T> extends DoubleList<T> implements  OrderedListADT<T> {

    public DoubleOrderedList(){

    }
    /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     */
    @Override
    public void add(T element) {
        if(!(element instanceof Comparable)){
            throw new NonComparableElementException("Double List");
        }
        DoubleNode<T> node = new DoubleNode<T>(element);
        Comparable<T> comparableElement = (Comparable<T>)element;
        Iterator<T> iter = this.iterator();
        DoubleNode<T> temp = head;
        if(size() > 0){
            if(size() == 1){
                //smaller than current.
               if((comparableElement).compareTo(temp.getElement()) < 0){

                   temp.setPrev(node);
                   node.setNext(temp);
                   if(temp.equals(head)){
                       head = node;
                   }
               }else{
                   //larger than current.
                   temp.setNext(node);
                   node.setPrev(temp);
               }
            }else {
                while (iter.hasNext()) {
                    //larger than current;
                    if (((Comparable<T>) element).compareTo(temp.getElement()) > 0) {
                        temp = temp.getNext();
                        iter.next();
                    } else {

                        DoubleNode<T> prev = temp.getPrev();

                        temp.setPrev(node);
                        node.setNext(temp);
                        if (null != prev) {
                            prev.setNext(node);
                            node.setPrev(prev);
                        } else {
                            head = node;
                        }
                        this.count ++;
                        return;
                    }
                }
                //we reached the end
                //target is larger than last element
                if(((Comparable<T>) element).compareTo(temp.getElement()) > 0){
                    temp.setNext(node);
                    node.setPrev(temp);
                }else{
                    //target is smaller than last element;
                    DoubleNode<T> prev = temp.getPrev();

                    temp.setPrev(node);
                    node.setNext(temp);
                    if (null != prev) {
                        prev.setNext(node);
                        node.setPrev(prev);
                    } 
                }
                //we reached the end.

            }
        }else{
            head = node;
        }


        this.count ++;
    }
}
