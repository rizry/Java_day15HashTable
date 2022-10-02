package com.java.day15.hashtable;

public class Main {

  public static void main(String[] args) {
    MyHashMap<String, Integer> hashMap = new MyHashMap<>();
    String str = "To be or not to be";
    String[] strArr = str.toLowerCase().split(" ");

    for (String word : strArr) {
      Integer value = hashMap.get(word);
      if (value == null) value = 1;
      else value += 1;
      hashMap.add(word, value);
    }
    System.out.println(hashMap);
    System.out.println("frequency of 'to': " + hashMap.get("to"));

    
    str = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
    MyLinkedHashMap<String, Integer> linkedHashMap = new MyLinkedHashMap<>();
    strArr = str.toLowerCase().split(" ");
    for (String word : strArr) {
      Integer value = linkedHashMap.get(word);
      if (value == null) value = 1;
      else value += 1;
      linkedHashMap.add(word, value);
    }
    System.out.println(linkedHashMap);
    System.out.println("frequency of 'paranoid': " + linkedHashMap.get("paranoid"));

  }

}