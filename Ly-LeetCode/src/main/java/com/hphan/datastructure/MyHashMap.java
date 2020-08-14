package com.hphan.datastructure;

import java.util.ArrayList;
import java.util.List;

class MyHashMap
{

    private int size = 10;
    private List<List<List<Integer>>> data = new ArrayList<List<List<Integer>>>();

    /** Initialize your data structure here. */
    public MyHashMap()
    {
	for (int i = 0; i < size; i++)
	{
	    data.add(new ArrayList<List<Integer>>());
	}
    }

    /** value will always be non-negative. */
    public void put(int key, int value)
    {
	List<Integer> dataPoint = new ArrayList<Integer>();
	dataPoint.add(key);
	dataPoint.add(value);

	int slot = extracted(key);

	if (get(key) != -1)
	    remove(key);
	data.get(slot).add(dataPoint);
    }

    private int extracted(int key)
    {
	return key % size;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key)
    {
	int slot = extracted(key);
	for (List<Integer> d : data.get(slot))
	{
	    if (key == d.get(0))
		return d.get(1);
	}
	return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key)
    {
	int slot = extracted(key);

	for (List<Integer> d : data.get(slot))
	{
	    if (key == d.get(0))
	    {
		data.get(slot).remove(d);
		break;
	    }
	}
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */