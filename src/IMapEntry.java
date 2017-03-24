/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public interface IMapEntry<K,V>
{
   public boolean equals (Object o);
   // post: returns true iff this entry <K,V> is equal to object o

   public K getKey();
   // post: returns the key K of this entry

   public V getValue();
   // post: returns the value V of this entry

   public int hashCode();
   // post: returns the hashcode for the key
   
   public V setValue(V value);
   // post: replaces the Value of this entry
   
 }
