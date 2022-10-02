package com.java.day15.hashtable;

public class MyMapNode<K, V> implements INode<K> {

  private K key;
  private V value;
  private MyMapNode<K, V> next;

  public MyMapNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public K getKey() {
    return key;
  }

  @Override
  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return this.value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public INode<K> getNext() {
    return next;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void setNext(INode<K> next) {
    this.next = (MyMapNode<K, V>) next;
  }

  @Override
  public String toString() {
    StringBuffer nodeString = new StringBuffer();
    nodeString.append("Node: {" + "K= ").append(key).append(", V= ").append(value).append('}');
    return nodeString.toString();
  }
  
}