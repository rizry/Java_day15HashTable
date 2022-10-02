package com.java.day15.hashtable;

public class MyHashMap<K, V> {

  MyLinkedList<K> myLinkedList;

  public MyHashMap() {
    this.myLinkedList = new MyLinkedList<>();
  }

  @SuppressWarnings("unchecked")
  public V get(K key) {
    MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.search(key);
    return (myMapNode == null) ? null : myMapNode.getValue();
  }

  @SuppressWarnings("unchecked")
  public void add(K key, V value) {
    MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.search(key);
    if (myMapNode == null) {
      myMapNode = new MyMapNode<>(key, value);
      this.myLinkedList.append(myMapNode);
    } else myMapNode.setValue(value);
  }

  @Override
  public String toString() {
    return "HashTable: {" + myLinkedList + "}";
  }

}