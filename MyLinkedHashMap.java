package com.java.day15.hashtable;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {

  private final int numBuckets;
  ArrayList<MyLinkedList<K>> myBucketArray;

  public MyLinkedHashMap() {
    this.numBuckets = 10;
    this.myBucketArray = new ArrayList<>(numBuckets);
    for (int i = 0; i < numBuckets; i++) this.myBucketArray.add(null);

  }

  private int getBucketIndex(K key) {
    int hashCode = Math.abs(key.hashCode());
    int index = hashCode % numBuckets;
    return index;
  }

  @SuppressWarnings("unchecked")
  public V get(K key) {
    int index = this.getBucketIndex(key);
    MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
    if (myLinkedList == null) return null;
    MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
    return (myMapNode == null) ? null : myMapNode.getValue();
  }

  @SuppressWarnings("unchecked")
  public void add(K key, V value) {
    int index = this.getBucketIndex(key);
    MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
    if (myLinkedList == null) {
      myLinkedList = new MyLinkedList<>();
      this.myBucketArray.set(index, myLinkedList);
    }
    MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
    if (myMapNode == null) {
      myMapNode = new MyMapNode<>(key, value);
      myLinkedList.append(myMapNode);
    } else myMapNode.setValue(value);
  }

  @SuppressWarnings("unchecked")
  public void remove(K key) {
    int index = this.getBucketIndex(key);
    MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
    if (myLinkedList == null) System.out.println("couldn't find " + key + " in the hashtable.");
    else {
      while (this.myBucketArray.get(index) != null) {
        INode<K> tempNode = myLinkedList.getHead();
        if (tempNode.getKey().equals(key) && tempNode.getNext() == null) myBucketArray.set(index, null);
        else if (tempNode.getKey().equals(key) && tempNode.getNext() != null) {
          myLinkedList.setHead(tempNode.getNext());
          break;
        } else {
          if (tempNode.getNext() != null) {
            while (tempNode.getNext().getNext() != null && !tempNode.getNext().getKey().equals(key)) tempNode = tempNode.getNext();
            tempNode.getNext().setKey((K) "");
            tempNode.setNext(tempNode.getNext().getNext());
            break;
          }
        }
      }
    }
  }

  @Override
  public String toString() {
    return "LinkedHashMap: {" + myBucketArray + "}";
  }

}