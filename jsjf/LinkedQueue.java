package jsjf;

import jsjf.exceptions.*;

/**
 * LinkedQueue represents a linked implementation of a queue.
 */
public class LinkedQueue<T> implements QueueADT<T>{
  private int count;
  private LinearNode<T> head, tail;

  /**
   * Creates an empty queue.
   */
  public LinkedQueue(){
    count = 0;
    head = tail = null;
  }

  /**
   * Adds the specified element to the tail of this queue.
   * @param element the element to be added to the tail of the queue
   */
  public void enqueue(T element){
    LinearNode<T> node = new LinearNode<T>(element);
    if(count==0)
    {
      head = node;
      tail = node;
    }
    else
    {
      tail.setNext(node);
      tail = node;
    }
    count ++;
  }

  /**
   * Removes the element at the head of this queue and returns a
   * reference to it.
   * @return the element at the head of this queue
   * @throws EmptyCollectionException if the queue is empty
   */
  public T dequeue() throws EmptyCollectionException{
    if(isEmpty())
      throw new EmptyCollectionException("queue");
    if(count==1)
    {
      T result  = head.getElement();
      tail = null;
      head = null;
      count--;
      return result;
    }
    T result = head.getElement();
    head = head.getNext();
    count--;
    return result;
  }

  /**
   * Returns a reference to the element at the head of this queue.
   * The element is not removed from the queue.
   * @return a reference to the first element in this queue
   * @throws EmptyCollectionsException if the queue is empty
   */
  public T first() throws EmptyCollectionException{
   // To be completed as a Programming Project
    return head.getElement();
  }

  /**
  * Returns true if this queue is empty and false otherwise.
  * @return true if this queue is empty
  */
  public boolean isEmpty(){
    // To be completed as a Programming Project
    return count==0;
  }

  /**
   * Returns the number of elements currently in this queue.
   * @return the number of elements in the queue
   */
  public int size(){
    // To be completed as a Programming Project
    return count;
  }

  /**
   * Returns a string representation of this queue.
   * @return the string representation of the queue
   */
  public String toString(){
    String result = "";
    LinearNode<T> trav = head;
    while(trav != null){
      result += trav.getElement();
      trav = trav.getNext();
    }
    return result;
  }
}
