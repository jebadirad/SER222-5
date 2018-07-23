package jsjf;

/**
 * A class that represents a doubly linked node. 
 *
 * @author JonDavid Ebadirad, Acuna
 * @version 1.0
 */
public class DoubleNode<T> {
    private DoubleNode<T> prev;
    private DoubleNode<T> next;
    private T element;

    public DoubleNode(){
           prev = null;
           next = null;
           element = null;

    }
    public DoubleNode(T elem){

        prev = null;
        next = null;
        element = elem;
    }
    public DoubleNode<T> getPrev(){
        return prev;
    }
    public DoubleNode<T> getNext(){
        return next;
    }

    public void setPrev(DoubleNode<T> node){

        prev = node;

    }
    public void setNext(DoubleNode<T> node){

        next = node;
    }
    public T getElement(){
        return element;
    }
    public void setElement(T elem){
        element = elem;
    }


}
