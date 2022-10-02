package com.java.day15.hashtable;

public class MyLinkedList<K> {

  private INode<K> head;
  private INode<K> tail;

  public INode<K> getHead() {
    return head;
  }

  public void setHead(INode<K> head) {
    this.head = head;
  }

  public INode<K> getTail() {
    return tail;
  }

  public void append(INode<K> newNode) {
    if (this.head == null) this.head = newNode;

    if (this.tail == null) this.tail = newNode;
    else {
      INode<K> tempNode = this.tail;
      this.tail = newNode;
      tempNode.setNext(tail);
    }

  }

  public INode<K> search(K key) {
    INode<K> tempNode = head;
    if (tempNode != null) {
      while (tempNode.getNext() != null) {
        if (tempNode.getKey().equals(key)) return tempNode;
        tempNode = tempNode.getNext();
      }
      if (tail.getKey().equals(key)) return tail;
    }
    return null;
  }

  @Override
  public String toString() {
    StringBuffer myMapNodeString = new StringBuffer();
    INode<K> temp = head;
    while (temp.getNext() != null) {
      myMapNodeString.append(temp).append(" -> ");
      temp = temp.getNext();
    }
    myMapNodeString.append(temp);
    return "LinkedList: {" + myMapNodeString + '}';
  }

}