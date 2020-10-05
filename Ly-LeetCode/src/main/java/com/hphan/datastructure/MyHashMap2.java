package com.hphan.datastructure;

/**
 * Implement again with link list instead of array list
 * 
 * @author Ly
 *
 */
class MyHashMap2
{
    
    class Node
    {
        int key;
        int value;
        Node next;
    }
    
    
    int capacity;
    Node[] cache;
    
    /** Initialize your data structure here. */
    public MyHashMap2() 
    {
        capacity = 100;
        cache = new Node[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) 
    {
        int hashKey = key % capacity;
        Node n = new Node();
        n.key = key;
        n.value = value;
        n.next = null;
        
        if (cache[hashKey] == null)
            cache[hashKey] = n;    
        else
        {
            boolean keyExists = false;
            Node run = cache[hashKey];
            while (run!=null)
            {
                if (run.key == key)
                {
                    keyExists = true;
                    break;
                }
                run = run.next;
            }
            if (!keyExists)
            {
                n.next = cache[hashKey];
                cache[hashKey] = n;
            }
            else
                run.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) 
    {
        int hashKey = key%capacity;
        if (cache[hashKey] == null)
            return -1;
        
        Node run = cache[hashKey];
        while (run!=null)
        {
            if (run.key == key)
                return run.value;
            run = run.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) 
    {
        int hashKey = key%capacity;
        if (cache[hashKey] !=null)
        {
            int count = 0;
            Node run = cache[hashKey];
            
            Node prev = null;
            while (run!=null)
                {
                count++;
                if (run.key == key)
                {
                if (prev == null)
                    cache[hashKey] = run.next;
                else
                    prev.next = run.next;
                }
                prev = run;
                run = run.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */